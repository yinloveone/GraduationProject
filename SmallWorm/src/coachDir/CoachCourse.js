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
export default class CoachCourse extends Component{
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
                    <Title>我的课程表</Title>
                </Body>
            </Header>
            <Content>
                <List>
                    <ListItem itemDivider>
                        <Text>A</Text>
                    </ListItem>
                    <ListItem>
                        <Text>5月20日</Text>
                        <Text>体操(09:00-10:00)</Text>
                        <Text>教室：A404</Text>
                    </ListItem>
                </List>
            </Content>
        </Container>
    )
    }
}