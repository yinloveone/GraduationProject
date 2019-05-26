import React,{ Component } from 'react'
import {
    Container, Header, Content, List, ListItem,
    Thumbnail, Text, Left, Body, Right, Button, Icon, Title
} from 'native-base';
import StorageUtil from "../utils/StorageUtil";
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid} from "react-native";
export default class StudentActivity extends Component{
    constructor(props){
        super(props)
        this.state={
            studentList:'',
        }
    }
    componentDidMount(): void {
        this.getStudentList();
    }

    /*
    * 根据教练id获取学生信息
    * */
    getStudentList=()=>{
        StorageUtil.get('coachId', (error, object) => {
            if (!error && object && object.coachId) {
                const url="http://47.100.239.1:8080/api/coach/getStudent/"+object.coachId
                HttpUtil.get(url).then(result=>{
                    if(result.code===0){
                        ToastAndroid.show(result.msg,ToastAndroid.SHORT);
                        this.setState({
                            studentList:result.data
                        })
                    }

                }).catch(error => {
                    console.log(error)
                })
            }})

    }


    render(){
        let avatar = require('../../img/6.png');
        if(!this.state.studentList) {
            return (
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的学员</Title>
                        </Body>
                    </Header>
                    <Content>
                      <Text>Loading...</Text>
                    </Content>
                </Container>
            )
        }else{
            return (
                <Container>
                    <Header>
                        <Left>
                            <Button transparent>
                                <Icon name='arrow-back' onPress={() => this.props.navigation.goBack()}/>
                            </Button>
                        </Left>
                        <Body>
                            <Title>我的学员</Title>
                        </Body>
                    </Header>
                    <Content padder>
                        <List
                                dataArray={this.state.studentList}
                                renderRow={data =>
                                    <ListItem>
                                            <Left>
                                                <Thumbnail square source={avatar}/>
                                            </Left>

                                        <Body>
                                            <Text>{data.stuName}</Text>
                                            <Text note numberOfLines={1}>电话:{data.phone}</Text>
                                            <Text note numberOfLines={1}>邮箱:{data.email}</Text>
                                        </Body>
                                        <Right/>
                                    </ListItem>}
                            />
                    </Content>
                </Container>
            )
        }

    }
}