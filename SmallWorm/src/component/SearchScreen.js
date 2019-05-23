import React, { Component } from 'react'
import {
    Container,
    Content,
    Icon,
    Item,
    Input,

} from 'native-base';

export default class SearchScreen extends Component{
    render() {
        return(
            <Container>
                <Content>
                    <Item regular>
                        <Input placeholder='输入条件' />
                        <Icon name='search' />
                    </Item>
                </Content>
            </Container>
        )
    }
}