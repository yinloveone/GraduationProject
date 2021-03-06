import React,{ Component } from 'react'
import {
    Container,
    Header,
    Right,
    Left,
    Body,
    Content,
    Button, Icon, Title, Text, List, ListItem, StyleProvider, DatePicker
} from "native-base";
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
import AntDesign from "react-native-vector-icons/AntDesign";
export default class CoachCourse extends Component{
    constructor(props) {
        super(props);
        this.state={
            courseList:'',
            chosenDate:null,
        }
    }
    componentDidMount(): void {
        this.getCoachCourse();
    }
    /*
    * 根据教练Id获取课程表
    * */
    getCoachCourse=()=>{
        StorageUtil.get('coachId', (error, object) => {
            if (!error && object && object.coachId) {
                const url="http://47.100.239.1:8080/api/courseRecord/getRecordByCoachId"
                const data={
                    coachId:object.coachId,
                    dateRange:this.state.chosenDate
                }
                HttpUtil.post(url,data).then(result=>{
                    if(result.code===0){
                      //  ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({
                            courseList:result.data
                        })
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }).catch(error => {
                    console.log(error)
                })
            }})
    }
    reload=()=>{
        StorageUtil.get('coachId', (error, object) => {
            if (!error && object && object.coachId) {
                const url="http://47.100.239.1:8080/api/courseRecord/getRecordByCoachId"
                const data={
                    coachId:object.coachId
                }
                HttpUtil.post(url,data).then(result=>{
                    if(result.code===0){
                      //  ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({
                            courseList:result.data
                        })
                    }else{
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                    }

                }).catch(error => {
                    console.log(error)
                })
            }})
    }
    setDate(newDate) {
        this.setState({ chosenDate: newDate });
        this.getCoachCourse();
    
    }
    renderItems() {
        const dataList = this.state.courseList;
        let replys = [];
        for (let i = 0; i < dataList.length; i++) {
            replys.push(<ListItem itemDivider key={dataList[i].yearMonth}>
                <Text>{dataList[i].yearMonth}</Text>
            </ListItem>)
            for (let j = 0; j < dataList[i].listCourse.length; j++) {
                replys.push(
                    <ListItem key={dataList[i].listCourse[j].courseId}>
                        <Body>
                            <Text>{dataList[i].listCourse[j].monthDate}</Text>
                            <Text>{dataList[i].listCourse[j].courseName}({dataList[i].listCourse[j].timeStartStr}-{dataList[i].listCourse[j].timeEndStr})</Text>
                            <Text>教室:{dataList[i].listCourse[j].roomName}</Text>
                        </Body>
                        <Right>
                            {
                                dataList[i].listCourse[j].courseTimeEnd<new Date().getTime()?
                                    <Button style={{width:80,height:30}} bordered onPress={this.getContent.bind(this,dataList[i].listCourse[j].courseId)}>
                                        <Text style={{fontSize:10}}>查看评论</Text>
                                    </Button>:
                                    <Button style={{width:80,height:30}} bordered onPress={this.getCourseSelect.bind(this,dataList[i].listCourse[j].courseId)}>
                                        <Text style={{fontSize:10}}>查看学员</Text>
                                    </Button>
                            }

                        </Right>
                    </ListItem>
                )
            }
        }
        return replys;
    }
    /*
    * 根据课程Id获取选课情况
    * */
    getCourseSelect = (courseId,e) => {
        this.props.navigation.navigate('CourseSignIn',{
            courseId:courseId
        })
    }
    getContent = (courseId,e) =>{
        this.props.navigation.navigate('DetailContent',{
            courseId:courseId
        })
    }

    render(){
        if(!this.state.courseList){
            return(
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的课程表</Title>
                        </Body>
                    </Header>
                    <Content>
                       <Text>Loading..</Text>
                    </Content>
                </Container>
                </StyleProvider>
            )

        }else{
            return(
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的课程表</Title>
                        </Body>
                        <Right>
                            <Button transparent onPress={this.reload}>
                                <AntDesign name='sync' size={16} style={{color: 'white'}}/>
                            </Button>
                            <Button transparent>
                                <AntDesign name='calendar' size={16} style={{color: 'white'}}/>
                                <DatePicker
                                    defaultDate={new Date()}
                                    minimumDate={new Date(2019,1,1)}
                                    maximumDate={new Date(2019, 12, 31)}
                                    locale={"en"}
                                    timeZoneOffsetInMinutes={undefined}
                                    modalTransparent={false}
                                    animationType={"fade"}
                                    androidMode={"spinner"}
                                    placeHolderText="选择时间"
                                    textStyle={{ color: "white" }}
                                    placeHolderTextStyle={{ color: "white" }}
                                    onDateChange={this.setDate.bind(this)}
                                    disabled={false}
                                />
                    
                            </Button>

                        </Right>
                    </Header>
                    <Content>
                        <List>
                            {this.renderItems()}
                        </List>
                    </Content>
                </Container>
                </StyleProvider>
            )
        }

    }
}