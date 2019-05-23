import React, { Component } from 'react'
import {
    Container,
    Thumbnail,
    Content,
    Tabs,
    Tab,
    Left,
    List, ListItem, Text, Button, Body, Right, ScrollableTab, Header, Icon,Title

} from 'native-base';

import TimeListUtil from '../utils/TimeListUtil'
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import StorageUtil from "../utils/StorageUtil";

const sankhadeep = require("../../img/header.jpg");
const datas = [
    {
        img: sankhadeep,
        id:1,
        textName: "徐行",
        info: "高级教练",
        courseName:'产后恢复训练(10:00-11:00)'
    },
    {
        img: sankhadeep,
        id:2,
        textName: "徐行",
        info: "高级教练",
        courseName:'产后恢复训练(9:00-10:00)'
    },
    ]

export default class HomeScreen extends Component {

    constructor(props) {
        super(props)
        this.state = {
            dataList:'',
            dates:TimeListUtil.getWeeks(new Date(new Date().getTime() + 48*60*60*1000)),
        }
    }
    componentDidMount(){
        this.getCourse(0);
    }
    getCourse(i){
        let nextDate = new Date(new Date().getTime() + (i+2)*24*60*60*1000);
        const url = 'http://47.100.239.1:8080/api/user/getPrivateCourse/'+nextDate;
        HttpUtil.get(url).then(result=>{
            if(result.code===0){
                ToastAndroid.show('请求成功',ToastAndroid.SHORT);
                this.setState({
                    dataList: result.data
                })
            }
        }).catch(error => {
            console.log(error)
        })
    }
    orderCourse(id,e){
        const url = 'http://47.100.239.1:8080/api/user/orderCourse';
        let stuId=0;
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                stuId = object.stuId;
            }
        });
        const courseRecord = {
            stuId: stuId,
            courseId: id
        }
        HttpUtil.post(url,courseRecord).then(result=>{
                ToastAndroid.show(result.msg,ToastAndroid.SHORT);
        }).catch(error =>{
            console.log(error)
        })
    }

    render() {
        return (
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>

                    <Body><Title>私教课</Title></Body>
                    <Right><Button transparent><Text>筛选</Text></Button></Right>
                </Header>
                <Content>
                    <Tabs renderTabBar={() => <ScrollableTab />}>
                        <Tab heading={this.state.dates[0]}>
                            <List
                                dataArray={this.state.dataList}
                                renderRow={data =>
                                    <ListItem thumbnail>
                                        <Left>
                                           {/* <Thumbnail  source={data.img} />*/}
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
                                            <Button success onPress={this.orderCourse.bind(this,data.id)}>
                                                <Text>预约</Text>
                                            </Button>
                                        </Right>
                                    </ListItem>}
                            />

                        </Tab>
                        <Tab heading={this.state.dates[1]}>

                        </Tab>
                        <Tab heading={this.state.dates[2]}>
                            <Text>3</Text>
                        </Tab>
                        <Tab heading={this.state.dates[3]}>
                            <Text>4</Text>
                        </Tab>
                        <Tab heading={this.state.dates[4]}>
                        </Tab>
                        <Tab heading={this.state.dates[5]}>
                        </Tab>
                        <Tab heading={this.state.dates[6]}>
                        </Tab>
                    </Tabs>

                </Content>
            </Container>
        )
    }
}

