import React, { Component } from 'react'
import {
    Container,
    Content,
    Icon,
    Item,
    Input, Header, Left, Button, Body, Title, Right, Text, Toast, StyleProvider

} from 'native-base';
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";

export default class ModifyPhoneScreen extends Component{
    constructor(props){
        super(props);
        this.state = {
            phone:null,
            errorPhone:''
        }
    }
    /*
     * 修改用户基本信息
     * */
    modifyUserInfo =() =>{
        if(!this.state.errorPhone&&this.state.phone) {

            StorageUtil.get('stuId', (error, object) => {
                if (!error && object && object.stuId) {
                    const url = 'http://47.100.239.1:8080/api/member/modifyStudent';
                    const student = {
                        stuId: object.stuId,
                        phone: this.state.phone
                    }
                    HttpUtil.post(url, student).then(result => {
                        if (result.code === 0) {
                            ToastAndroid.show(result.msg, ToastAndroid.SHORT);
                            this.props.navigation.goBack();
                            this.props.navigation.state.params.refresh();
                        } else {
                            ToastAndroid.show(result.msg, ToastAndroid.SHORT);
                        }
                        console.log(result.msg)
                    }).catch(error => {
                        console.log(error);
                    })
                }
            })
        }else{
            Toast.show({
                text: "请输入正确电话的电话号码",
                buttonText: "确定",
                duration: 3000
            })
        }
    }
    render() {

        return(
            <StyleProvider style={getTheme(material)}>
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>修改电话</Title></Body>
                    <Right>
                        <Button transparent onPress={this.modifyUserInfo}>
                            <Text>确认</Text>
                        </Button>
                    </Right>
                </Header>
                <Content padder>
                    <Item>
                        <Input placeholder='输入电话' onChangeText={ phone => this.setState({phone},()=>{
                            let myreg=new RegExp("/^[1][3,4,5,7,8][0-9]{9}$/")
                            if(this.state.phone.length===0||this.state.phone===null){
                                this.setState({errorPhone:'请输入电话号码'})
                            }else if(!myreg.test(this.state.phone)){
                                this.setState({errorPhone:'请输入正确的电话号码'})
                            }else{
                                this.setState({errorPhone:''})
                            }
                        })} value={this.state.phone} />
                    </Item>
                    <Text style={{color:'red'}}>{this.state.errorPhone}</Text>
                </Content>
            </Container>
            </StyleProvider>
        )
    }
}