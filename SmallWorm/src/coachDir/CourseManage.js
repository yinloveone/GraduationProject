import React,{ Component } from 'react'
import {
    Body,
    Button,
    Container,
    Content,
    Header,
    Icon,
    Left,
    Text,
    Title,
    Right,
    ListItem,
    List,
    StyleProvider
} from "native-base";
import AntDesign from "react-native-vector-icons/AntDesign";
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
import getTheme from "../../native-base-theme/components";
import material from "../../native-base-theme/variables/material";
export default class CourseManage extends Component{
    constructor(props){
        super(props)
        this.state={
            courseList:''
        }
    }
    componentDidMount(): void {
        this.getCoachCourse();
    }
    getCoachCourse=()=>{
        StorageUtil.get('coachId', (error, object) => {
            if (!error && object && object.coachId) {
                const url="http://47.100.239.1:8080/api/course/getPrivateList/"+object.coachId
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
    turnOnPage(pageName) {
        this.props.navigation.navigate(pageName,{
            refresh:()=>{
                this.getCoachCourse();
            }})
    }
    updateCourse = (courseId,e) =>{
        this.props.navigation.navigate('UpdateCourse',{
            courseId:courseId
        },{
            refresh:()=>{
                this.getCoachCourse();
            }})
    }
    renderItems() {
        const dataList = this.state.courseList;
        let replys = [];
        for (let i = 0; i < dataList.length; i++) {
                replys.push(
                    <ListItem key={dataList[i].courseId}>
                        <Body>
                            <Text>2019-06-30</Text>
                            <Text>{dataList[i].courseName}({dataList[i].timeStartStr}-{dataList[i].timeEndStr})</Text>
                            <Text>教室:{dataList[i].roomName}</Text>
                        </Body>
                        <Right>
                            <Button success onPress={this.updateCourse.bind(this,dataList[i].courseId)}>
                                <Text>编辑</Text>
                            </Button>
                        </Right>
                    </ListItem>
                )
        }
        return replys;
    }
    render(){
        if(!this.state.courseList){
            return (
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>课程管理</Title>
                        </Body>
                        <Right>
                            <Button transparent onPress={() => this.turnOnPage('AddCourse')}>
                                <AntDesign name='plus' size={22} style={{color: 'white'}}/>
                            </Button>
                        </Right>
                    </Header>
                    <Content>
                        <Text>没有课程</Text>
                    </Content>
                </Container>
                </StyleProvider>
            )

        }else {


            return (
                <StyleProvider style={getTheme(material)}>
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>课程管理</Title>
                        </Body>
                        <Right>
                            <Button transparent onPress={() => this.turnOnPage('AddCourse')}>
                                <AntDesign name='plus' size={22} style={{color: 'white'}}/>
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