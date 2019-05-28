/**
 * @format
 */

import {AppRegistry} from 'react-native';
import App from './App';
import {name as appName} from './app.json';
import { Root } from 'native-base';
import React from "react";

const RootApp = () => (
    <Root>
        <App/>
    </Root>
);
AppRegistry.registerComponent(appName, () => RootApp);
