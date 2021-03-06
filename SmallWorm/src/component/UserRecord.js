import React, { Component } from 'react';
import {
    Body,
    Button,
    Container,
    Content, Header, Icon, Left, Right, StyleProvider,
    Text, Title
} from "native-base";

import MyCharts from 'native-echarts';
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import AntDesign from "react-native-vector-icons/AntDesign";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";

export default class UserRecord extends Component {
    constructor(props) {
        super(props);
        this.state = {
            weightData:null,
            weightList:null,
            dateList:null
        }
    }
    componentDidMount(){
        this.getUserWeight();
    }
    turnOnPage(pageName) {
        this.props.navigation.navigate(pageName,{
            refresh:()=>{
                this.getUserWeight();
            }})
    }
    getUserWeight= () =>{

        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/weight/getWeightList/'+object.stuId;
                //object.stuId;
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                       // ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        let a=[],b=[];
                        for(var i=0;i<result.data.length;i++){
                            a.push(result.data[i].weight);
                            b.push(result.data[i].recordTimeStr)
                        }
                        this.setState({weightData:result.data,
                            weightList:a,
                            dateList:b
                        });

                       // console.log(result.data[0].weight)
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }) .catch(error => {
                    console.log(error);
                })
            }})
    }
    render() {
        if(!this.state.weightData) {
            return(
                <StyleProvider style={getTheme(material)}>
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>我的体重</Title></Body>
                    <Right>
                        <Button transparent onPress={() => this.turnOnPage('AddWeight')}>
                            <AntDesign name='plus' size={22} style={{color: 'white'}}/>
                        </Button>

                    </Right>
                </Header>
                <Content>
                    <Text>Loading</Text>
                </Content>
            </Container>
                </StyleProvider>
            )
        }else{
            const option = {
                title: {
                    text: '体重折线图'
                },
                tooltip: {},
                legend: {
                    data: ['体重']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']}
                    }
                },
                calculable : true,
                xAxis: {
                    data: this.state.dateList
                },
                yAxis: {
                    type: 'value'
                },
                series: [{
                    name: '体重',
                    type: 'line',
                    data: this.state.weightList
                }]
            };
            return (
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body><Title>我的体重</Title></Body>
                        <Right>
                            <Button transparent onPress={() => this.turnOnPage('AddWeight')}>
                                <AntDesign name='plus' size={22} style={{color: 'white'}}/>
                            </Button>
                        </Right>
                    </Header>
                    <Content>
                    <MyCharts option={option} height={300}/>
                    </Content>
                </Container>
                </StyleProvider>
            )
        }
    }
}
