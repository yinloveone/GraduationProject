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
import {Col} from "react-native-easy-grid";
import StarScore from "../views/StarScore"

export default class SubmitScore extends Component{
    constructor(props){
        super(props);
        let courseRecordId = this.props.navigation.state.params.courseRecordId;
        this.state = {
            courseRecordId:courseRecordId,
            currentScore:3,
        }
    }
    /*
     * 课程评分
     * */
    submitScore =() =>{
        const record={
            courseRecordId:this.state.courseRecordId,
            score:this.state.currentScore
        }
        const url='http://47.100.239.1:8080/api/courseRecord/submitScore';
        HttpUtil.post(url,record).then(result=>{
            if(result.code===0){
                ToastAndroid.show(result.msg, ToastAndroid.SHORT);
                this.props.navigation.goBack();
            }else{
                ToastAndroid.show(result.msg, ToastAndroid.SHORT);
            }

        }).catch(error=>{
            console.log(error)
        })

    }
    _selectIndex(count) {
        this.state.currentScore = count;
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
                    <Body><Title>课程评分</Title></Body>
                    <Right>
                        <Button transparent onPress={this.submitScore}>
                            <Text>确认</Text>
                        </Button>
                    </Right>
                </Header>
                <Content padder>
                    <Text>请为课程评分:</Text>
                    <StarScore selectIndex={this._selectIndex.bind(this)}/>
                </Content>
            </Container>
        )
    }
}