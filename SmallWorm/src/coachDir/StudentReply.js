import React,{ Component } from 'react'
import {Body, Button, Container, Content, Header, Icon, Left, Right, StyleProvider, Text, Title} from "native-base";
import MyCharts from 'native-echarts';
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid,View,Dimensions} from "react-native";
const DeviceHeight = Dimensions.get('window').height

export default class StudentReply extends Component{
    constructor(props){
        super(props)
        this.state={
            avgScores:null,
            courseList:null

        }
    }
    componentDidMount(): void {
        this.getContent();
    }

    getContent = ()=> {

        StorageUtil.get('coachId', (error, object) => {
            if (!error && object && object.coachId) {
                const url = 'http://47.100.239.1:8080/api/courseRecord/getContent/'+object.coachId;
                //object.stuId;
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                        let a=[],b=[];
                        for(var i=0;i<result.data.length;i++){
                            a.push(result.data[i].courseName);
                            b.push(result.data[i].avgScore)
                        }
                        this.setState({weightData:result.data,
                            courseList:a,
                            avgScores:b
                        });

                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }) .catch(error => {
                    console.log(error);
                })
            }})
    }
    render(){
        const option = {
            title : {
                text: '课程评分图'
            },
            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['平均分']
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
            xAxis : [
                {
                    type : 'category',
                    data : this.state.courseList
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            itemStyle: {
                // 普通样式。
                normal: {
                    // 点的颜色。
                    color: '#355C7D'
                },
                // 高亮样式。
                emphasis: {
                    // 高亮时点的颜色。
                    color: '#355C7D'
                }
            },
            series : [
                {
                    name:'平均分',
                    type:'bar',
                    data:this.state.avgScores,
                    markPoint : {
                        data : [
                            {type : 'max', name: '最大值'},
                            {type : 'min', name: '最小值'}
                        ]
                    },
                    markLine : {
                        data : [
                            {type : 'average', name: '平均值'}
                        ]
                    }
                }

            ]
        };
        return(
            <StyleProvider style={getTheme(material)}>
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>学员反馈</Title></Body>
                    <Right/>
                </Header>
                <Content padder>
                    <View style={{paddingTop:DeviceHeight*0.1}}>
                    <MyCharts option={option} height={300}/>
                    </View>
                </Content>
            </Container>
            </StyleProvider>
        )
    }
}