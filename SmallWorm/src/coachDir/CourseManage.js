import React,{ Component } from 'react'
import {Body, Button, Container, Content, Header, Icon, Left, Text, Title,Right} from "native-base";
import AntDesign from "react-native-vector-icons/AntDesign";
export default class CourseManage extends Component{
    turnOnPage(pageName) {
        this.props.navigation.navigate(pageName);
    }
    render(){
        return(
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
                            <AntDesign name='plus'  style={{color: 'white'}}/>
                        </Button>
                    </Right>
                </Header>
                <Content>
                    <Text>CoachCourse</Text>
                </Content>
            </Container>
        )
    }
}