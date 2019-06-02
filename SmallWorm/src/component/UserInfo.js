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
const sankhadeep = require("../../img/6.png");
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import ImagePicker from 'react-native-image-crop-picker';
import StorageUtil from "../utils/StorageUtil";
import {Grid, Row} from "react-native-easy-grid";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
export default class UserInfo extends Component{
    _imageObj = {
        path: ''
    };
    constructor(props){
        super(props);
        this.state = {
            userInfo:null,
            avatarSource:"../../img/6.png",
            spinner:true,
            imageUrl:'',
            birthday:'',

        }
        this.addOnClicked=this.addOnClicked.bind(this)
    }
    componentDidMount(){
        this.getUserInfo();
    }
     formatToString = (timestamp, formater) => {
        let date = new Date();
        date.setTime(parseInt(timestamp));
        formater = (formater != null) ? formater : 'yyyy-MM-dd hh:mm';
        Date.prototype.Format = function (fmt) {
            var o = {
                "M+": this.getMonth() + 1, //月
                "d+": this.getDate(), //日
                "h+": this.getHours(), //小时
                "m+": this.getMinutes(), //分
                "s+": this.getSeconds(), //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds() //毫秒
            };

            if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o) {
                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ?
                    (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            }
            return fmt;
        }
        return date.Format(formater);
    };

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
                      //  ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        let birthdayStr
                        if(null!=result.data.birthday){
                             birthdayStr = this.formatToString(result.data.birthday,'yyyy-MM-dd');
                        }else{
                            birthdayStr = "";
                        }
                        this.setState({
                            userInfo:result.data,
                            avatarSource:'http://47.100.239.1:8080'+result.data.studentPortrait,
                            birthday:birthdayStr
                        })

                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }) .catch(error => {
                    console.log(error);
                })
            }})
            }

    turnOnPage(pageName) {
        this.props.navigation.navigate(pageName,{
            refresh:()=>{
                this.getUserInfo();
            }})
    }

    addOnClicked(){
        let _this=this
        ImagePicker.openPicker({
            width: 300,
            height: 300,
            cropping: true
        }).then(image => {

           StorageUtil.get('stuId', (error, object) => {

                 if (!error && object && object.stuId) {
                     let formData = new FormData();
                     formData.append('file', {
                         uri: image['path'],
                         name: image['path'],
                         type: 'image/jpeg'
                     });
                     formData.append('stuId',object.stuId);
                     const fetchOptions = {
                         method: 'POST',
                         body: formData
                     };
                     const url='http://47.100.239.1:8080/api/member/uploadPortrait'

                     fetch(url,fetchOptions).
                     then(function(response) {
                         return response.json();
                     }).then(function(data) {
                         if(data.code===0) {
                             _this.setState({
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
                </StyleProvider>
            );

        }else{
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

                        <List>
                            <ListItem onPress={this.addOnClicked.bind(this)}>
                                <Left>
                                    <Text>头像</Text>
                                </Left>
                                <Right>
                                    <Thumbnail small source={{uri: this.state.avatarSource }}/>
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
                            <ListItem onPress={() => this.turnOnPage('ModifyPhoneScreen')}>

                                    <Text>手机号码</Text>

                                    <Text style={{width:'80%',textAlign:'right'}}>{this.state.userInfo.phone}</Text>

                            </ListItem>
                            <ListItem>
                                <Left>
                                    <Text>性别</Text>
                                </Left>
                                <Right>
                                    {this.state.userInfo.sex===1?<Text>女</Text>:<Text>男</Text>
                                    }
                                </Right>
                            </ListItem>
                            <ListItem onPress={() => this.turnOnPage('ModifyBirthScreen')}>
                                    <Text>生日</Text>
                                    <Text style={{width:'90%',textAlign:'right'}}>{this.state.birthday}</Text>

                            </ListItem>
                            <ListItem onPress={() => this.turnOnPage('ModifyHeightScreen')}>
                                <Left>
                                    <Text>身高</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.height}</Text>
                                </Right>
                            </ListItem>
                            <ListItem onPress={() => this.turnOnPage('ModifyWeightScreen')}>
                                <Left>
                                    <Text>体重</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.weight}</Text>
                                </Right>
                            </ListItem>
                        </List>
                    <Grid style={{marginTop: 50}}>
                        <Row
                            style={{width: '100%', height: '100%', alignItems: 'center', justifyContent: 'center'}}>
                            <Button rounded onPress={() => {
                                this.turnOnPage('UpdateStuPassword')
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