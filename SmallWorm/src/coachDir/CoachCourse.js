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
                const url="http://47.100.239.1:8080/api/courseRecord/getRecordByCoachId/"+object.coachId
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({
                            courseList:result.data
                        })
                    }

                }).catch(error => {
                    console.log(error)
                })
            }})
    }
    setDate(newDate) {
        /*this.setState({ chosenDate: newDate });
        const course={
            courseTimeStart:newDate
        }
        const url = 'http://47.100.239.1:8080/api/user/getCourse';
        HttpUtil.post(url,course).then(result=>{
            if(result.code===0){
                this.setState({
                    dataList: result.data
                })
            }else{
                this.setState({
                    dataList: null
                })
            }
            console.log(result)
        }).catch(error => {
            console.log(error)
        })*/
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
                            <Button bordered onPress={this.getCourseSelect.bind(this,dataList[i].listCourse[j].courseId)}>
                                <Text>详情</Text>
                            </Button>
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