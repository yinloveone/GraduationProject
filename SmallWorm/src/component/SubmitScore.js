import React, { Component } from 'react'
import {
    Container,
    Content,
    Icon,
    Item,
    Textarea, Header, Left, Button, Body, Title, Right, Text, Toast, StyleProvider

} from 'native-base';
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {Dimensions, ToastAndroid} from "react-native";
import {Col,Grid,Row} from "react-native-easy-grid";
import StarScore from "../views/StarScore"
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
const DeviceWidth = Dimensions.get('window').width

export default class SubmitScore extends Component{
    constructor(props){
        super(props);
        let courseRecordId = this.props.navigation.state.params.courseRecordId;
        this.state = {
            courseRecordId:courseRecordId,
            currentScore:3,
            content:'',
        }
    }
    /*
     * 课程评分
     * */
    submitScore =() =>{
        const record={
            courseRecordId:this.state.courseRecordId,
            score:this.state.currentScore,
            content:this.state.content
        }
        const url='http://47.100.239.1:8080/api/courseRecord/submitScore';
        HttpUtil.post(url,record).then(result=>{
            if(result.code===0){
                ToastAndroid.show(result.msg, ToastAndroid.SHORT);
                this.props.navigation.goBack();
                this.props.navigation.state.params.refresh();
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
            <StyleProvider style={getTheme(material)}>
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>课程评分</Title></Body>
                    <Right/>
                </Header>
                <Content padder>
                    <Grid style={{width:DeviceWidth*0.9}}>
                        <Row style={{width:'100%'}}>
                            <Col>
                    <Text>请为课程评分:</Text></Col>
                        </Row>
                        <Row style={{width:'100%'}}>
                            <Col>
                    <Textarea rowSpan={5} bordered placeholder="写下你的评论"
                              onChangeText={content =>
                                  this.setState({ content })
                              }
                              value={this.state.content} /></Col>
                        </Row>
                        <Row style={{textAlign: 'right',width:'100%',marginTop:10}}>
                            <Col style={{textAlign: 'right',width:'100%',flexDirection: 'row',justifyContent:'flex-end'}}>
                                <StarScore selectIndex={this._selectIndex.bind(this)}/>
                            </Col>
                        </Row>
                        <Row style={{width:'100%',marginTop:10}}>
                            <Col style={{textAlign: 'right',width:'100%',flexDirection: 'row',justifyContent:'center'}}>
                            <Button success onPress={this.submitScore}>
                                <Text>确认</Text>
                            </Button></Col>
                        </Row>
                    </Grid>
                </Content>
            </Container>
            </StyleProvider>
        )
    }
}