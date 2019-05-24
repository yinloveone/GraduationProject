import React,{ Component } from 'react';
import {
    Container,
    Header,
    Content,
    List,
    ListItem,
    Text,
    Button,
    Icon,
    Left,
    Body,
    Title,
    Right
} from 'native-base';
import HttpUtil from '../utils/HttpUtil'
import StorageUtil from "../utils/StorageUtil";
import {ToastAndroid} from "react-native";
/*const  dataList =[{
        month:"4月",
        course:[
            {
                courseId:1,
               courseName:"体操",
                courseTimeStart: "4月12日 09:15"},
            {
                courseId:2,
                courseName:"瑜伽",
                courseTimeStart:"4月12日 13:00"},

            ]
    },
    {
        month:"5月",
        course:[
            {
                courseId: 1,
                courseName: "体操",
                courseTimeStart: "5月12日 09:15"},
            {
                courseId:2,
                courseName:"瑜伽",
                courseTimeStart:"5月12日 13:00"},
        ]
    }
]*/

export default  class CourseScreen extends Component{
    constructor(props){
        super(props)
        this.state = {
            dataList:null
        }
    }
    componentDidMount(){
        this.getCourseOrder()
    }

    getCourseOrder(){

        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                const url = 'http://47.100.239.1:8080/api/courseRecord/getRecordById/'+object.stuId;
                HttpUtil.get(url).then(result=>{
                    if(result.code === 0){
                        this.setState({
                            dataList:result.data
                        })
                    }

                }).catch(error => {
                    console.log(error)
                })
                    }
                })
    }
    cancelCourse(courseId,e){
        const url='http://47.100.239.1:8080/api/user/cancelOrder'
        let stuId=0;
        StorageUtil.get('stuId', (error, object) => {
            if (!error && object && object.stuId) {
                stuId = object.stuId;

        const courseRecord = {
            courseId:courseId,
            stuId:object.stuId
        }
        HttpUtil.post(url,courseRecord).then(result=>{
            if(result.code===0){
                this.getCourseOrder();
            }
            ToastAndroid.show(result.msg,ToastAndroid.SHORT);

        }).catch(error=>{
            console.log(error)
        })
            }
        });

    }

    renderItems(){
        const dataList=this.state.dataList;
        let replys = [];
        for(let i=0;i<dataList.length;i++){
            replys.push( <ListItem itemDivider>
                <Text>{dataList[i].yearMonth}</Text>
            </ListItem>)
            for(let j=0;j<dataList[i].listCourse.length;j++){
                replys.push(
                    <ListItem>
                        <Body>
                            <Text>{dataList[i].listCourse[j].monthDate}</Text>
                            <Text>{dataList[i].listCourse[j].courseName}({dataList[i].listCourse[j].timeStartStr}-{dataList[i].listCourse[j].timeEndStr})</Text>
                            <Text>上课老师:{dataList[i].listCourse[j].coachName}</Text>
                            <Text>教室:{dataList[i].listCourse[j].roomName}</Text>
                            <Text>消耗课时:1课时</Text>
                        </Body>
                        <Right>
                            <Button danger onPress={this.cancelCourse.bind(this,dataList[i].listCourse[j].courseId)}>
                                <Text>退课</Text>
                            </Button>
                        </Right>
                    </ListItem>
                )
            }
        }
        return replys;
    }

    render() {
        if (!this.state.dataList) {
            return (
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的课表</Title>
                        </Body>
                        <Right/>
                    </Header>
                    <Content>
                        <Text>loading...</Text>
                    </Content>
                </Container>
            )
        } else {
            return (
                <Container>
                    <Header>
                        <Left>
                            <Button transparent onPress={() => this.props.navigation.goBack()}>
                                <Icon name="arrow-back"/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的课表</Title>
                        </Body>
                        <Right/>
                    </Header>
                    <Content>
                        <List>
                            {this.renderItems()}
                        </List>

                    </Content>
                </Container>

            )
        }
    }

}
