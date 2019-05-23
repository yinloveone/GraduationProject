import React, { Component } from "react";
import { Image } from "react-native";
import {
    Container,
    Header,
    Title,
    Content,
    Button,
    Icon,
    Card,
    CardItem,
    Text,
    Thumbnail,
    Left,
    Body,
    Right
} from "native-base";

const logo = require("../../img/6.png");
const cardImage = require("../../img/header.jpg");

export default class ClubCard extends Component{
    render() {
        return (
            <Container>
                <Header>
                    <Left>
                        <Button transparent onPress={() => this.props.navigation.goBack()}>
                            <Icon name="arrow-back" />
                        </Button>
                    </Left>
                    <Body>
                        <Title>我的会员卡</Title>
                    </Body>
                    <Right />
                </Header>

                <Content padder>
                    <Card>
                        <CardItem>
                            <Left>
                                <Thumbnail source={logo} />
                                <Body>
                                    <Text>可摘星辰</Text>
                                    <Text note>普通会员</Text>
                                </Body>
                            </Left>
                        </CardItem>

                        <CardItem cardBody>
                            <Image
                                style={{
                                    resizeMode: "cover",
                                    width: null,
                                    height: 200,
                                    flex: 1
                                }}
                                source={cardImage}
                            />
                        </CardItem>

                        {/*<CardItem style={{ paddingVertical: 0 }}>
                            <Left>
                                <Button transparent>
                                    <Icon active name="thumbs-up" />
                                    <Text>4923 Likes</Text>
                                </Button>
                            </Left>
                            <Body>
                                <Button transparent>
                                    <Icon active name="chatbubbles" />
                                    <Text>89 Comments</Text>
                                </Button>
                            </Body>
                            <Right>
                                <Text>11h ago</Text>
                            </Right>
                        </CardItem>*/}
                    </Card>
                </Content>
            </Container>
        );
    }
}