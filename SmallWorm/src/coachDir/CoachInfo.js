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
import HttpUtil from "../utils/HttpUtil";
import {ToastAndroid, TouchableHighlight} from "react-native";
import StorageUtil from "../utils/StorageUtil";
import {Grid, Row,Col} from "react-native-easy-grid";
export default class CoachInfo extends Component{
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
                            <Thumbnail small source={sankhadeep}/>
                        </Right>
                    </ListItem>
                    <ListItem>
                        <Left>
                            <Text>用户名/昵称</Text>
                        </Left>
                        <Right>
                            <Text>倪</Text>
                        </Right>
                    </ListItem>
                    <ListItem>
                        <Left>
                            <Text>手机号码</Text>
                        </Left>
                        <Right>
                            <Text>13013752039</Text>
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
                            <Text>级别</Text>
                        </Left>
                        <Right>
                            <Text>初级</Text>
                        </Right>
                    </ListItem>
                </List>
                <Grid style={{marginTop:50}}>
                    <Row style={{width: '100%', height: '100%', alignItems: 'center', justifyContent: 'center'}}>
                <Button rounded  onPress={() => {
                    this.turnOnPage('UpdatePassword')
                }}>
                    <Icon name='cog' />
                    <Text>修改密码</Text>
                </Button>
                </Row>
                </Grid>
            </Content>
        </Container>
    )
}

}
