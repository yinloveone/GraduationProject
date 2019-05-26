import React,{ Component } from 'react'
import {
    Container,
    Header,
    Right,
    Left,
    Body,
    Content,
    Button, Icon, Title,Text,List, ListItem
} from "native-base";
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
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
                            <Button onPress={this.getCourseSelect.bind(this,dataList[i].listCourse[j].courseId)}>
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
            )

        }else{
            return(
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
                        <List>
                            {this.renderItems()}
                        </List>
                    </Content>
                </Container>
            )
        }

    }
}