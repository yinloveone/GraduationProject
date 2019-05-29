import React,{ Component } from 'react'
import {Body, Button, Container, Content, Header, Icon, Left, Right, Text, Title} from "native-base";
import MyCharts from 'native-echarts';
import AntDesign from "react-native-vector-icons/AntDesign";
export default class StudentReply extends Component{
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
                    magicType : {show: true, type: ['line', 'bar']},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['体操课','瑜伽课','形体芭蕾','肚皮舞']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'平均分',
                    type:'bar',
                    data:[2.0, 4.9, 4.2, 3.3],
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
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back"/>
                        </Button>
                    </Left>
                    <Body><Title>我的体重</Title></Body>
                    <Right>
                        <Button transparent>
                            <AntDesign name='plus' size={22} style={{color: 'white'}}/>
                        </Button>

                    </Right>
                </Header>
                <Content>
                    <MyCharts option={option} height={300}/>
                </Content>
            </Container>
        )
    }
}