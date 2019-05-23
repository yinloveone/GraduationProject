import React, { Component } from 'react';
import {
    Container,
    Content,
    Header,
    Left,
    Body,
    Right,
    Text,
    List,
    ListItem,
    Icon,
    Button,
    Title, Thumbnail
} from "native-base";
const sankhadeep = require("../../img/header.jpg");
export default class UserInfo extends Component{
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
                        <Title>个人资料</Title>
                    </Body>
                </Header>
                <Content>
                    <List>
                        <ListItem>
                            <Left>
                                <Text>头像</Text>
                            </Left>
                            <Right>
                                <Thumbnail small source={sankhadeep} />
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>用户名/昵称</Text>
                            </Left>
                            <Right>
                                <Text>可摘星辰</Text>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>我的宣言</Text>
                            </Left>
                            <Right>
                                <Text>我最棒啦
                                </Text>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>手机号码</Text>
                            </Left>
                            <Right>
                                <Text>15123447644</Text>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>性别</Text>
                            </Left>
                            <Right>
                                <Text>女</Text>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>生日</Text>
                            </Left>
                            <Right>
                                <Text>5-20</Text>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>身高</Text>
                            </Left>
                            <Right>
                                <Text>155</Text>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>初始体重</Text>
                            </Left>
                            <Right>
                                <Text>52</Text>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>目标体重</Text>
                            </Left>
                            <Right>
                                <Text>47</Text>
                            </Right>
                        </ListItem>
                    </List>
                </Content>
            </Container>
        )
    }
}