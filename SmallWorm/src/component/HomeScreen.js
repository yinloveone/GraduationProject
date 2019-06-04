import React, { Component } from 'react'
import {
    Container,
    Thumbnail,
    Content,
    Tabs,
    Tab,
    Left,
    List, ListItem, Text, Button, Body, Right, ScrollableTab, Header, Icon,Title,StyleProvider

} from 'native-base';

import TimeListUtil from '../utils/TimeListUtil'
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import StorageUtil from "../utils/StorageUtil";
import material from './../../native-base-theme/variables/material';
import getTheme from './../../native-base-theme/components';

const sankhadeep = require("../../img/header.jpg");

export default class HomeScreen extends Component {

    constructor(props) {
        super(props)
        this.state = {
            dataList:'',
            dates:TimeListUtil.getWeeks(new Date(new Date().getTime() + 48*60*60*1000)),
            indexi:0,
        }
    }
    componentDidMount(){
        this.getCourse(0);
    }
    getCourse=(i)=>{
        this.setState({
            dataList:'',
            indexi:i,
        })
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
               // stuId = object.stuId;

        let nextDate = new Date(new Date().getTime() + (i+2)*24*60*60*1000);
        const url = 'http://47.100.239.1:8080/api/user/getPrivateCourse';
        const privateCourse={
            courseTimeStart:nextDate,
            stuId:object.stuId,

        }
        HttpUtil.post(url,privateCourse).then(result=>{
            if(result.code===0){
               // ToastAndroid.show('请求成功',ToastAndroid.SHORT);
                this.setState({
                    dataList: result.data
                })
                console.log(result.data[0].courseName)
            }else{
               // ToastAndroid.show(result.msg,ToastAndroid.SHORT);
            }
        }).catch(error => {
            console.log(error)
        })
            }
        });
    }
    orderCourse(id,e){
        const url = 'http://47.100.239.1:8080/api/user/orderCourse';
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
               // stuId = object.stuId;
                const courseRecord = {
                    stuId: object.stuId,
                    courseId: id
                }
                HttpUtil.post(url,courseRecord).then(result=>{
                    this.getCourse(0);
                    if(result.code===0){
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);

                    }

                }).catch(error =>{
                    console.log(error)
                })


            }
        });

    }

    render() {
        return (
            <StyleProvider style={getTheme(material)}>
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>私教课</Title></Body>
                    <Right></Right>
                </Header>
                <Content>
                    <Tabs renderTabBar={() => <ScrollableTab />} onChangeTab={({i})=>this.getCourse(i)}>
                        <Tab heading={this.state.dates[0]}>
                            {
                                this.state.dataList ?<List
                                    dataArray={this.state.dataList}
                                    renderRow={data =>
                                        <ListItem thumbnail>
                                            <Left>
                                                <Thumbnail source={{uri:'http://47.100.239.1:8080'+data.coachPortrait}}/>
                                            </Left>
                                            <Body>
                                                <Text>
                                                    {data.coachName}
                                                </Text>
                                                <Text>
                                                    {data.gradeStr}
                                                </Text>
                                                <Text note style={{color:'#0000ff'}}>
                                                    {data.courseName}({data.timeStartStr}-{data.timeEndStr})
                                                </Text>
                                            </Body>
                                            <Right>
                                                <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                    <Text>预约</Text>
                                                </Button>
                                            </Right>
                                        </ListItem>}
                                /> :<Text>没有数据</Text>

                            }

                        </Tab>
                        <Tab heading={this.state.dates[1]}>
                            {
                                this.state.dataList ?<List
                                    dataArray={this.state.dataList}
                                    renderRow={data =>
                                        <ListItem thumbnail>
                                            <Left>
                                                <Thumbnail source={{uri:'http://47.100.239.1:8080'+data.coachPortrait}}/>
                                            </Left>
                                            <Body>
                                                <Text style={{fontSize: 22}}>
                                                    {data.coachName}
                                                </Text>
                                                <Text>
                                                    {data.gradeStr}
                                                </Text>
                                                <Text note style={{color:'#0000ff'}}>
                                                    {data.courseName}({data.timeStartStr}-{data.timeEndStr})
                                                </Text>
                                            </Body>
                                            <Right>
                                                <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                    <Text>预约</Text>
                                                </Button>
                                            </Right>
                                        </ListItem>}
                                /> :<Text>没有数据</Text>

                            }

                        </Tab>
                        <Tab heading={this.state.dates[2]}>
                            {
                                this.state.dataList ?<List
                                    dataArray={this.state.dataList}
                                    renderRow={data =>
                                        <ListItem thumbnail>
                                            <Left>
                                                <Thumbnail source={{uri:'http://47.100.239.1:8080'+data.coachPortrait}}/>
                                            </Left>
                                            <Body>
                                                <Text>
                                                    {data.coachName}
                                                </Text>
                                                <Text>
                                                    {data.gradeStr}
                                                </Text>
                                                <Text note style={{color:'#0000ff'}}>
                                                    {data.courseName}({data.timeStartStr}-{data.timeEndStr})
                                                </Text>
                                            </Body>
                                            <Right>
                                                <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                    <Text>预约</Text>
                                                </Button>
                                            </Right>
                                        </ListItem>}
                                /> :<Text>没有数据</Text>

                            }

                        </Tab>
                        <Tab heading={this.state.dates[3]}>
                            {
                                this.state.dataList ?<List
                                    dataArray={this.state.dataList}
                                    renderRow={data =>
                                        <ListItem thumbnail>
                                            <Left>
                                                <Thumbnail source={{uri:'http://47.100.239.1:8080'+data.coachPortrait}}/>
                                            </Left>
                                            <Body>
                                                <Text>
                                                    {data.coachName}
                                                </Text>
                                                <Text>
                                                    {data.gradeStr}
                                                </Text>
                                                <Text note style={{color:'#0000ff'}}>
                                                    {data.courseName}({data.timeStartStr}-{data.timeEndStr})
                                                </Text>
                                            </Body>
                                            <Right>
                                                <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                    <Text>预约</Text>
                                                </Button>
                                            </Right>
                                        </ListItem>}
                                /> :<Text>没有数据</Text>

                            }

                        </Tab>
                        <Tab heading={this.state.dates[4]}>
                            {
                                this.state.dataList ?<List
                                    dataArray={this.state.dataList}
                                    renderRow={data =>
                                        <ListItem thumbnail>
                                            <Left>
                                                <Thumbnail source={{uri:'http://47.100.239.1:8080'+data.coachPortrait}}/>
                                            </Left>
                                            <Body>
                                                <Text>
                                                    {data.coachName}
                                                </Text>
                                                <Text>
                                                    {data.gradeStr}
                                                </Text>
                                                <Text note style={{color:'#0000ff'}}>
                                                    {data.courseName}({data.timeStartStr}-{data.timeEndStr})
                                                </Text>
                                            </Body>
                                            <Right>
                                                <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                    <Text>预约</Text>
                                                </Button>
                                            </Right>
                                        </ListItem>}
                                /> :<Text>没有数据</Text>

                            }

                        </Tab>
                        <Tab heading={this.state.dates[5]}>
                            {
                                this.state.dataList ?<List
                                    dataArray={this.state.dataList}
                                    renderRow={data =>
                                        <ListItem thumbnail>
                                            <Left>
                                                <Thumbnail source={{uri:'http://47.100.239.1:8080'+data.coachPortrait}}/>
                                            </Left>
                                            <Body>
                                                <Text style={{fontSize:20,color:'#efefef'}}>
                                                    {data.coachName}
                                                </Text>
                                                <Text>
                                                    {data.gradeStr}
                                                </Text>
                                                <Text note style={{color:'#0000ff'}}>
                                                    {data.courseName}({data.timeStartStr}-{data.timeEndStr})
                                                </Text>
                                            </Body>
                                            <Right>
                                                <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                    <Text>预约</Text>
                                                </Button>
                                            </Right>
                                        </ListItem>}
                                /> :<Text>没有数据</Text>
                            }

                        </Tab>
                        <Tab heading={this.state.dates[6]}>
                            {
                                this.state.dataList ?<List
                                    dataArray={this.state.dataList}
                                    renderRow={data =>
                                        <ListItem thumbnail>
                                            <Left>
                                                <Thumbnail source={{uri:'http://47.100.239.1:8080'+data.coachPortrait}}/>
                                            </Left>
                                            <Body>
                                                <Text>
                                                    {data.coachName}
                                                </Text>
                                                <Text>
                                                    {data.gradeStr}
                                                </Text>
                                                <Text note style={{color:'#0000ff'}}>
                                                    {data.courseName}({data.timeStartStr}-{data.timeEndStr})
                                                </Text>
                                            </Body>
                                            <Right>
                                                <Button success onPress={this.orderCourse.bind(this,data.courseId)}>
                                                    <Text>预约</Text>
                                                </Button>
                                            </Right>
                                        </ListItem>}
                                /> :<Text>没有数据</Text>

                            }
                        </Tab>
                    </Tabs>

                </Content>
            </Container>
            </StyleProvider>
        )
    }
}

