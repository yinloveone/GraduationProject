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
import DatePicker from "react-native-datepicker";
import {Col} from "react-native-easy-grid";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";

export default class ModifyBirthScreen extends Component{
    constructor(props){
        super(props);
        this.state = {
            birthday:null,
        }
    }
    /*
     * 修改用户基本信息
     * */
    modifyUserInfo =() =>{
        if(this.state.birthday) {
            StorageUtil.get('stuId', (error, object) => {
                if (!error && object && object.stuId) {
                    const url = 'http://47.100.239.1:8080/api/member/modifyStudent';
                    const student = {
                        stuId: object.stuId,
                        birthday: this.state.birthday
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
                text: "请选择生日日期",
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
                    <Body><Title>输入生日</Title></Body>
                    <Right>
                        <Button transparent onPress={this.modifyUserInfo}>
                            <Text>确认</Text>
                        </Button>
                    </Right>
                </Header>
                <Content padder>
                    <Item>
                        <DatePicker
                            style={{width: '100%'}}
                            date={this.state.birthday}
                            mode="date"
                            format="YYYY-MM-DD"
                            confirmBtnText="确定"
                            cancelBtnText="取消"
                            showIcon={false}
                            onDateChange={(birthday) =>  this.setState({birthday:birthday})}
                        />
                    </Item>
                </Content>
            </Container>
            </StyleProvider>
        )
    }
}