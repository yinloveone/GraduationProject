import React, { Component } from 'react';
import {
    Container,
    Header,
    Content,
    Form,
    Item,
    Input,
    Label,
    Icon,
    Button,
    Left,
    Body,
    Segment,
    Text,
    Right, StyleProvider,
    H1
} from "native-base";
import { Grid, Row } from "react-native-easy-grid";

import HttpUtil from '../utils/HttpUtil';
import StorageUtil from '../utils/StorageUtil';
import navigationUtil from '../utils/navigationUtil'
import {ToastAndroid} from "react-native";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";


export  default class UserLogin extends Component {
    constructor(props){
        super(props);
        this.state = {
            userName: '',
            errorUserName: '',
            password: '',
            errorPass: '',
            seg: 1,
            coachPassword:'',
            coachName:'',
        }
        StorageUtil.get('username', (error, object) => {
            if (!error && object && object.username) {
                this.setState({username: object.username});
            }
        });


    }
    handleChange = ()=>{
        if(this.state.userName === ''){
            this.setState({
                errorUserName: '请输入用户名'
            })
        }else if(this.state.userName !== ''){
            this.setState({
                errorUserName: ''
            })
        }
        if (this.state.password === '') {
            this.setState({
                errorPass: '请输入密码, '
            })
        } else if (this.state.password !== '') {
            this.setState({
                errorPass: ''
            })
        }

    }
    handleCoachLogin = () =>{
        const coach = {
            coachName: this.state.coachName,
            password: this.state.coachPassword

        }
        const url ='http://47.100.239.1:8080/api/coach/login'
        HttpUtil.post(url,coach).then(result=>{
            if(result.code === 0){
                StorageUtil.set('hasLogin', {'hasLogin': 'COACH'});
                StorageUtil.set('coachId',{'coachId':result.data.coachId});
                StorageUtil.set('userName', {'userName': this.state.coachName});
                StorageUtil.set('password', {'password': this.state.coachPassword});
                //跳页面
                navigationUtil.reset(this.props.navigation, 'MainCoach');
            }else{
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
            }

        }).catch(error => {
            console.log(error)
        })

    }

    handleLogin = () =>{
        const student = {
            stuName: this.state.userName,
            password: this.state.password,
        }
        const url = 'http://47.100.239.1:8080/api/user/stuLogin';
        HttpUtil.post(url,student).then(result=>{
            if(result.code===0){
                //储存用户信息
                StorageUtil.set('hasLogin', {'hasLogin': 'STUDENT'});
                StorageUtil.set('stuId',{'stuId':result.data.stuId});
                StorageUtil.set('userName', {'userName': this.state.userName});
                StorageUtil.set('password', {'password': this.state.password});
                //跳页面
                navigationUtil.reset(this.props.navigation, 'MainStudent');

            }else{
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
            }
        }) .catch(error => {
            console.log(error);
        })

    }
    render(){
        return(
            <StyleProvider style={getTheme(material)}>
            <Container>
                <Header hasSegment>
                    <Left>
                            <Text style={{
                                color:'#fff',fontSize:12
                            }}>SmallWorm</Text>
                    </Left>
                        <Body>
                            <Segment>
                                <Button
                                    active={this.state.seg === 1 ? true : false}
                                    first
                                    onPress={() => this.setState({ seg: 1 })}
                                >
                                    <Text>会员</Text>
                                </Button>
                                <Button
                                    last
                                    active={this.state.seg === 2 ? true : false}
                                    onPress={() => this.setState({ seg: 2 })}
                                >
                                    <Text>教练</Text>
                                </Button>
                            </Segment>
                        </Body>
                    <Right>
                    </Right>
                </Header>

                {this.state.seg === 1 &&
                <Grid>
                    <Row style={{width: '100%', height: '20%'}}>
                    </Row>
                    <Row style={{width: '100%', height: '80%'}}>
                        <Content>
                            <Form>
                                <Item floatingLabel>
                                    <Label>邮箱/手机号码</Label>
                                    <Input
                                        onChangeText={userName =>
                                            this.setState({ userName }, () => {
                                                if (this.state.userName === '') {
                                                    this.setState({
                                                        errorUserName: '请输入密码, '
                                                    })
                                                } else if (this.state.userName !== '') {
                                                    this.setState({
                                                        errorUserName: ''
                                                    })
                                                }
                                            })
                                        }
                                        value={this.state.userName}/>

                                </Item>
                                <Item floatingLabel>
                                    <Label>密码</Label>
                                    <Input
                                        onChangeText={password =>
                                            this.setState({ password }, () => {
                                                if (this.state.password === '') {
                                                    this.setState({
                                                        errorPass: '请输入密码, '
                                                    })
                                                } else if (this.state.password !== '') {
                                                    this.setState({
                                                        errorPass: ''
                                                    })
                                                }
                                            })
                                        }
                                        secureTextEntry={true}
                                        value={this.state.password}
                                    />
                                </Item>
                            </Form>
                        <Row style={{width: '100%', height: '30%',flexDirection:"column",alignItems:'center',justifyItems:'center'}}>
                            <Button bordered style={{marginTop: 50,width:50,height:50,borderRadius:30,alignSelf:'center'}} onPress={this.handleLogin}>
                                <Icon name='arrow-forward' />
                            </Button>
                        </Row>
                        </Content>
                    </Row>
                </Grid>}
                {this.state.seg === 2 && <Grid>
                    <Row style={{width: '100%', height: '20%'}}>

                    </Row>
                    <Row style={{width: '100%', height: '80%'}}>
                        <Content>
                            <Form>
                                <Item floatingLabel>
                                    <Label>用户名</Label>
                                    <Input
                                        onChangeText={coachName =>
                                            this.setState({ coachName }, () => {
                                                if (this.state.coachName === '') {
                                                    this.setState({
                                                        errorUserName: '请输入密码, '
                                                    })
                                                } else if (this.state.coachName !== '') {
                                                    this.setState({
                                                        errorUserName: ''
                                                    })
                                                }
                                            })
                                        }
                                        value={this.state.coachName}/>
                                </Item>
                                <Item floatingLabel>
                                    <Label>密码</Label>
                                    <Input
                                        onChangeText={coachPassword =>
                                            this.setState({ coachPassword }, () => {
                                                if (this.state.coachPassword === '') {
                                                    this.setState({
                                                        errorPass: '请输入密码, '
                                                    })
                                                } else if (this.state.coachPassword !== '') {
                                                    this.setState({
                                                        errorPass: ''
                                                    })
                                                }
                                            })
                                        }
                                        secureTextEntry={true}
                                        value={this.state.coachPassword}
                                    />
                                </Item>
                            </Form>
                            <Row style={{width: '100%', height: '30%',flexDirection:"column",alignItems:'center',justifyItems:'center'}}>
                                <Button bordered style={{marginTop: 50,width:50,height:50,borderRadius:30,alignSelf:'center'}} onPress={this.handleCoachLogin}>
                                    <Icon name='arrow-forward' />
                                </Button>
                            </Row>
                        </Content>
                    </Row>
                </Grid>}
            </Container>
            </StyleProvider>
        )
    }

}
