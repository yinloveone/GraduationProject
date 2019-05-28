import React, { Component } from 'react'
import {
    Container,
    Content,
    Icon,
    Item,
    Input, Header, Left, Button, Body, Title, Right, Text, Toast

} from 'native-base';
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";

export default class ModifyWeightScreen extends Component{
    constructor(props){
        super(props);
        this.state = {
            weight:null,
        }
    }
    /*
     * 修改用户基本信息
     * */
    modifyUserInfo =() =>{
        if(this.state.weight) {
            StorageUtil.get('stuId', (error, object) => {
                if (!error && object && object.stuId) {
                    const url = 'http://47.100.239.1:8080/api/member/modifyStudent';
                    const student = {
                        stuId: object.stuId,
                        weight: this.state.weight
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
                text: "请先输入体重",
                buttonText: "确定",
                duration: 3000
            })
        }
    }
    render() {

        return(
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>输入体重</Title></Body>
                    <Right>
                        <Button transparent onPress={this.modifyUserInfo}>
                            <Text>确认</Text>
                        </Button>
                    </Right>
                </Header>
                <Content padder>
                    <Item>
                        <Input placeholder='输入体重(kg)' onChangeText={ weight => this.setState({weight},()=>{
                        })} value={this.state.weight} />
                    </Item>
                </Content>
            </Container>
        )
    }
}