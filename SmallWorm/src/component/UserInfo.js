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
    Title, Thumbnail
} from "native-base";
const sankhadeep = require("../../img/header.jpg");
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import StorageUtil from "../utils/StorageUtil";
export default class UserInfo extends Component{
    constructor(props){
        super(props);
        this.state = {
            userInfo:null,
        }
    }
    componentDidMount(){
        this.getUserInfo();
    }
    /*
    * 获取用户基本信息
    * */
    getUserInfo = () =>{

        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/member/getStudent/'+object.stuId;
                //object.stuId;
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({userInfo:result.data})
                        //console.log(result.data)
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }) .catch(error => {
                    console.log(error);
                })
            }})
            }

    turnOnPage(pageName) {
        this.props.navigation.navigate(pageName);
    }
    render(){
        if(!this.state.userInfo){
            return(
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>个人资料</Title>
                        </Body>
                        <Right/>
                    </Header>
                    <Content>
                        <Text>loading...</Text>
                    </Content>
                </Container>
            );

        }else{
        return(
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
                            <ListItem>
                                <Left>
                                    <Text>头像</Text>
                                </Left>
                                <Right>
                                    <Thumbnail small source={sankhadeep}/>
                                </Right>
                            </ListItem>
                            <ListItem onPress={() => this.turnOnPage('ModifyScreen')}>
                                <Left>
                                    <Text>用户名/昵称</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.stuName}</Text>
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
                                    <Text>女</Text>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>生日</Text>
                                </Left>
                                <Right>
                                    <Text>5-20</Text>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>身高</Text>
                                </Left>
                                <Right>
                                    <Text>155</Text>
                                </Right>
                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>体重</Text>
                                </Left>
                                <Right>
                                    <Text>52</Text>
                                </Right>
                            </ListItem>
                        </List>
                </Content>
            </Container>
        )
        }

    }
}