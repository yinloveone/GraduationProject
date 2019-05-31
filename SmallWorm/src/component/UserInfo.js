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
            avatarSource:'',
            spinner:true

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
                      //  ToastAndroid.show(result.msg,ToastAndroid.SHORT);
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
        this.props.navigation.navigate(pageName,{
            refresh:()=>{
                this.getUserInfo();
            }})
    }
    addOnClicked(){
        //这里对应，native-image-crop-picker组件，看一下就知道为什么了。
        ImagePicker.openPicker({
            multiple: true,
            minFiles:3,
            maxFiles:5,
            cropperChooseText:"确定",
            cropperCancelText:"取消",
        }).then(images => {
            //这里我就采用for循环遍历上传了，因为我的是多选，返回的是一个Images的数组。如果是单选的话，这里直接返回的就是当前图片的信息。
          /*  for(let image in images){*/
                //HTTPUtil.baseUrL 是对应你上传的方法的url,dispatch/uploadImage就是具体的方法地址。
                this.uploadFile('http://47.100.239.1:8080/'+'dispatch/uploadImage',images['path'],images['path'],"image.jpg");
            /*}*/
        });
    }
     uploadFile(url, fileUrl,fileName) {
        //这里要注意，把当前this，存储下来。
        let thisObj = this;
        //可以忽略，就是过度效果。
        thisObj.setState({ spinner: true });
        let formData = new FormData();
        formData.append('file', {
            uri: fileUrl,
            name: fileName,
            type: 'image/jpeg'
        });
        const fetchOptions = {
            method: 'POST',
            body: formData
        };

        fetch(url,fetchOptions).
        then(function(response) {
            thisObj.setState({ spinner: false });
            return response.json();
        }).then(function(data) {
            //这里的url 是你上传完，server给返回的url地址，理论上就是一个get请求，就可以拿到图片信息。
            let url = 'http://47.100.239.1:8080/' +"upload/"+data.data;
            let imageUrls;
            imageUrls = thisObj.state.avatarSource;
            //把当前的图片url，存起来
            imageUrls.add(url);
            //这里调用setState，来更新我们的视图层。
            thisObj.setState({avatarSource:imageUrls})
            thisObj.setState({ spinner: false });
        }).catch(function(e) {
            console.info(e);
        });
    }

    _openPicker(){
        ImagePicker.openPicker({
            width: 300,
            height: 300,
            cropping: true
        }).then(image => {
            console.log("111111" + image['data']);
            this.setState({
                imageUrl: {uri: image['path']}
            });
            let params = {
                path:  this._imageObj['path'],    //本地文件地址
            };
            this.uploadImage('uploadImage', params)
                .then( res=>{
                    console.log('success');
                }).catch( err=>{
                //请求失败
                console.log('flied');
            })
            this._imageObj = image;
        })
    }
   uploadImage =(url, params)=> {
        return new Promise(function (resolve, reject) {
            var ary = params.path.split('/');
            console.log('2222222' + ary);
            let formData = new FormData();
            let file = {uri: params.path, type: 'multipart/form-data', name: ary[ary.length-1]};
            formData.append("file", file);

            fetch('http://47.100.239.1:8080/birds/' + url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Content-Encoding': 'identity'
                },
                body: JSON.stringify(formData),
            }).then((response) => response.json())
                .then((responseData)=> {
                    console.log('uploadImage', responseData);
                    resolve(responseData);
                })
                .catch((err)=> {
                    console.log('err', err);
                    reject(err);
                });
        });
    };

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
                            <ListItem onPress={this.addOnClicked}>
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
                            <ListItem onPress={() => this.turnOnPage('ModifyPhoneScreen')}>
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
                                    {this.state.userInfo.sex===1?<Text>女</Text>:<Text>男</Text>
                                    }
                                </Right>
                            </ListItem>
                            <ListItem onPress={() => this.turnOnPage('ModifyBirthScreen')}>
                                <Left>
                                    <Text>生日</Text>
                                </Left>
                                <Right>
                                    <Text>{this.state.userInfo.birthday}</Text>
                                </Right>
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