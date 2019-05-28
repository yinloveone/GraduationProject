import React, { Component } from 'react'
import {
    Container,
    Content,
    Icon,
    Item,
    Input, Header, Left, Button, Body, Title, Right,Text

} from 'native-base';
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";

export default class AddWeight extends Component{
    constructor(props){
        super(props);
        this.state = {
            addWeight:null,
        }
    }
    /*
    * 记录体重
    * */
    addWeight = () =>{
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/weight/insertWeight';
                const weightRecord ={
                    stuId:object.stuId,
                    weight:this.state.addWeight
                }
                HttpUtil.post(url,weightRecord).then(result=>{
                    if(result.code===0){
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.props.navigation.goBack();
                        this.props.navigation.state.params.refresh();
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }
                    console.log(result.msg)
                }) .catch(error => {
                    console.log(error);
                })
            }})

    }
    render(){
        return(
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>记录今日体重</Title></Body>
                    <Right>
                        <Button transparent onPress={this.addWeight}>
                            <Text>确认</Text>
                        </Button>
                    </Right>
                </Header>
                <Content>
                    <Item>
                        <Input placeholder='输入体重' onChangeText={ addWeight => this.setState({addWeight},()=>{
                        })} value={this.state.addWeight} />
                    </Item>
                </Content>
            </Container>
        )
    }

}