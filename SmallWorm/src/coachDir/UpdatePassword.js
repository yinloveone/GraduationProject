import React, { Component } from 'react';
import {
    Container, Header, Content, Item, Input,
    Left, Button, Icon, Body, Title, Text, Label, StyleProvider
} from 'native-base';
import {Grid, Row,Col} from "react-native-easy-grid";
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import navigationUtil from "../utils/navigationUtil";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";

export default class UpdatePassword extends Component{
    constructor(props){
        super(props);
        this.state = {
            prmiPassword:null,
            newPassword:'',
            comPassword:'',
            errorPass:'',
            errorPass1:'',
            errorPass2:'',

        }
    }
    handleChange = ()=>{
        if (this.state.prmiPassword === '') {
            this.setState({
                errorPass: '请输入原密码'
            })
        } else if (this.state.prmiPassword !== '') {
            this.setState({
                errorPass: ''
            })
        }
        if (this.state.newPassword === '') {
            this.setState({
                errorPass1: '请输入旧密码'
            })
        } else if (this.state.newPassword !== '') {
            this.setState({
                errorPass1: ''
            })
        }
        if (this.state.comPassword === '') {
            this.setState({
                errorPass2: '请确认密码'
            })
        } else if (this.state.comPassword !== '') {
            this.setState({
                errorPass2: ''
            })
        }
    }
    submitPassword=()=>{

        StorageUtil.get('password', (error, object) => {
            if (!error && object && object.password) {
                if(this.state.prmiPassword===object.password) {
                    StorageUtil.get('coachId', (error, object) => {
                        if (!error && object && object.coachId) {
                            const coach={
                                coachId:object.coachId,
                                password:this.state.newPassword
                            }
                            const url="http://47.100.239.1:8080/api/coach/updatePassword"
                            HttpUtil.post(url,coach).then(result=>{
                                if(result.code===0){
                                    ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                                    StorageUtil.set('hasLogin', {'hasLogin': 'FALSE'});
                                    navigationUtil.reset(this.props.navigation, 'UserLogin');
                                }else{
                                    ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                                }

                            }).catch(error => {
                                console.log(error)
                            })
                        }})


                }else{
                    ToastAndroid.show('原密码错误',ToastAndroid.SHORT);
                }
            }})

    }
    render() {
        return (
            <StyleProvider style={getTheme(material)}>
            <Container>
                <Header>
                    <Left>
                        <Button transparent>
                            <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                        </Button>
                    </Left>
                    <Body>
                        <Title>修改密码</Title>
                    </Body>
                </Header>
                <Content>
                    <Grid style={{width:'100%', height: '100%',marginTop:50}}>
                        <Row style={{width:'100%'}}>
                            <Item  style={{width:'100%'}}>
                                <Label>旧密码</Label>
                                <Input  onChangeText={prmiPassword =>
                                    this.setState({ prmiPassword }, () => {
                                        if (this.state.prmiPassword === '') {
                                            this.setState({
                                                errorPass: '请输入旧密码'
                                            })
                                        } else if (this.state.prmiPassword !== '') {
                                            this.setState({
                                                errorPass: ''
                                            })
                                        }
                                    })
                                }
                                        secureTextEntry={true}
                                        value={this.state.prmiPassword}/>
                            </Item>
                        </Row>
                        <Row style={{width:'100%',marginBottom:20}}>
                            <Text style={{ color: 'red', fontSize: 12 }}>{this.state.errorPass}</Text>
                        </Row>
                        <Row style={{width:'100%',marginBottom:20}}>
                    <Item  style={{width:'100%'}}>
                        <Label>新密码</Label>
                        <Input  onChangeText={newPassword =>
                            this.setState({ newPassword }, () => {
                                if (this.state.newPassword === '') {
                                    this.setState({
                                        errorPass1: '请输入新密码'
                                    })
                                } else if (this.state.newPassword !== '') {
                                    this.setState({
                                        errorPass1: ''
                                    })
                                }
                                if (this.state.newPassword !== this.state.comPassword) {
                                    this.setState({
                                        errorPass2: '密码不一致'
                                    })
                                } else if (this.state.newPassword === this.state.comPassword) {
                                    this.setState({
                                        errorPass2: ''
                                    })
                                }
                            })
                        }
                                secureTextEntry={true}
                                value={this.state.newPassword}/>
                    </Item>
                        </Row>
                        <Row style={{width:'100%',marginBottom:20}}>
                            <Text style={{ color: 'red', fontSize: 12 }}>{this.state.errorPass1}</Text>
                        </Row>
                        <Row style={{width:'100%',marginBottom:20}}>
                    <Item  style={{width:'100%'}}>
                        <Label>确认密码</Label>
                        <Input onChangeText={comPassword =>
                            this.setState({ comPassword }, () => {
                                if (this.state.newPassword !== this.state.comPassword) {
                                    this.setState({
                                        errorPass2: '密码不一致'
                                    })
                                } else if (this.state.newPassword === this.state.comPassword) {
                                    this.setState({
                                        errorPass2: ''
                                    })
                                }
                            })
                        }
                               secureTextEntry={true}
                               onChange={this.handleChange}
                               value={this.state.comPassword}/>
                    </Item>
                        </Row>
                        <Row style={{width:'100%',marginBottom:20}}>
                            <Text style={{ color: 'red', fontSize: 12 }}>{this.state.errorPass2}</Text>
                        </Row>
                        <Row style={{width: '100%', height: '100%', alignItems: 'center', justifyContent: 'center'}}>
                            <Button onPress={this.submitPassword}>
                                <Text>提交</Text>
                            </Button>
                        </Row>
                    </Grid>

                </Content>
            </Container>
            </StyleProvider>
        );
    }
}