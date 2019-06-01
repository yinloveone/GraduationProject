import React, { Component } from 'react';
import {
    Container,
    Content,
    Header,
    Left,
    Body,
    Right,
    Text,
    List,
    ListItem,
    Icon,
    Button,
    Title, Thumbnail, StyleProvider
} from "native-base";
const sankhadeep = require("../../img/header.jpg");
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid, TouchableHighlight} from "react-native";
import StorageUtil from "../utils/StorageUtil";
import {Grid, Row,Col} from "react-native-easy-grid";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
import ImagePicker from "../component/UserInfo";
export default class CoachInfo extends Component{
    constructor(props){
        super(props)
        this.state={
            userInfo:'',
            avatarSource:"../../img/6.png",
        }
        this.addOnClicked=this.addOnClicked.bind(this)
    }
    componentDidMount(): void {
        this.getUserInfo();
    }

    turnOnPage(pageName) {
        this.props.navigation.navigate(pageName);

    }
    /*
   * 获取用户基本信息
   * */
    getUserInfo = () =>{

        StorageUtil.get('coachId', (error, object) => {
            if (!error && object && object.coachId) {
                const url = 'http://47.100.239.1:8080/api/coach/getCoach/'+object.coachId;
                //object.stuId;
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({userInfo:result.data,
                            avatarSource:'http://47.100.239.1:8080'+result.data.coachPortrait
                        })
                        //console.log(result.data)
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }) .catch(error => {
                    console.log(error);
                })
            }})
    }
    addOnClicked(){
        ImagePicker.openPicker({
            width: 300,
            height: 300,
            cropping: true
        }).then(image => {

            StorageUtil.get('coachId', (error, object) => {

                if (!error && object && object.coachId) {
                    let formData = new FormData();
                    formData.append('file', {
                        uri: image['path'],
                        name: image['path'],
                        type: 'image/jpeg'
                    });
                    formData.append('coachId',object.coachId);
                    const fetchOptions = {
                        method: 'POST',
                        body: formData
                    };
                    const url='http://47.100.239.1:8080/api/coach/uploadPortrait'

                    fetch(url,fetchOptions).
                    then(function(response) {
                        return response.json();
                    }).then(function(data) {
                        if(data.code===0) {
                            this.setState({
                                avatarSource:'http://47.100.239.1:8080'+data.data
                            })
                            let url = 'http://47.100.239.1:8080' + data.data;
                            console.log(url)
                        }else{
                            console.log(data.code)
                        }

                    }).catch(function(e) {
                        console.info(e);
                    });
                }})
        }).catch(err=>{
            console.log(err)
        })

    }

render(){
        if(!this.state.userInfo){
            return(
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>个人资料</Title>
                        </Body>
                    </Header>
                    <Content>
                        <Text>Loading...</Text>
                    </Content>
                </Container>
                </StyleProvider>
            )
        }
    else {
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
                            <Title>个人资料</Title>
                        </Body>
                    </Header>
                    <Content>

                        <List>
                            <ListItem onPress={this.addOnClicked}>
                                <Left>
                                    <Text>头像</Text>
                                </Left>
                                <Right>
                                    <Thumbnail small source={{uri:this.state.avatarSource}}/>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>用户名/昵称</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.coachName}</Text>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>手机号码</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.phone}</Text>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>性别</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.sex}</Text>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>生日</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.birthdayStr}</Text>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>级别</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.gradeStr}</Text>
                                </Right>
                            </ListItem>
                        </List>
                        <Grid style={{marginTop: 50}}>
                            <Row
                                style={{width: '100%', height: '100%', alignItems: 'center', justifyContent: 'center'}}>
                                <Button rounded onPress={() => {
                                    this.turnOnPage('UpdatePassword')
                                }}>
                                    <Icon name='cog'/>
                                    <Text>修改密码</Text>
                                </Button>
                            </Row>
                        </Grid>
                    </Content>
                </Container>
                </StyleProvider>
            )
        }
}

}
