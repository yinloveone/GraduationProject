/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {StyleSheet, View} from 'react-native';
import UserLogin from './src/auth/UserLogin'
import  { createBottomTabNavigator,createAppContainer,createStackNavigator  }from 'react-navigation'

import Icons from 'react-native-vector-icons/MaterialCommunityIcons'

import StorageUtil from './src/utils/StorageUtil'
import Home from './src/component/HomeScreen'
import Profile from './src/component/ProfileScreen'
import UserRecord from './src/component/UserRecord'
import UserIndex from './src/component/UserIndex'
import CourseScreen from './src/component/CourseScreen'
import UserInfo from './src/component/UserInfo'
import CourseHour from './src/component/CourseHour'
import ClubCard from './src/component/ClubCard'
import StudentActivity from './src/coachDir/StudentActivity'
import CoachCourse from './src/coachDir/CoachCourse'
import AddCourse from './src/coachDir/AddCourse'
import CoachIndex from './src/coachDir/CoachIndex'
import CourseSignIn from './src/coachDir/CourseSignIn'
import ModifyScreen from './src/component/ModifyScreen'
import AddWeight from  './src/component/AddWeight'
import CoachInfo from './src/coachDir/CoachInfo'
import UpdatePassword from './src/coachDir/UpdatePassword'
import StudentReply from './src/coachDir/StudentReply'
import CourseManage from './src/coachDir/CourseManage'
import UpdateCourse from './src/coachDir/UpdateCourse'
import UpdateStuPassword from './src/component/UpdateStuPassword'
import ModifyWeightScreen from './src/component/ModifyWeightScreen'
import ModifyHeightScreen from './src/component/ModifyHeightScreen'
import ModifyBirthScreen from './src/component/ModifyBirthScreen'
import ModifyPhoneScreen from './src/component/ModifyPhoneScreen'
import SubmitScore from './src/component/SubmitScore'

 const MainStudent = createBottomTabNavigator({
    Home: {
        screen:  Home,
        navigationOptions: {
            tabBarLabel: '私教约课',
            tabBarIcon: ({tintColor, focused}) => (
                <Icons
                    name={focused ? 'account' : 'account-outline'}
                    size={26}
                    style={{color: tintColor}}
                />
            ),
        }
    },
    Details: {
        screen:Profile,
        navigationOptions: {
            tabBarLabel: '团体约课',
            tabBarIcon: ({tintColor, focused}) => (
                <Icons
                    name={focused ? 'account-group' : 'account-group-outline'}
                    size={26}
                    style={{color: tintColor}}
                />
            ),
        }
    },
    UserRecord: {
        screen:UserRecord,
        navigationOptions: {
            tabBarLabel: '数据',
            tabBarIcon: ({tintColor, focused}) => (
                <Icons
                    name={focused ? 'egg' : 'egg-easter'}
                    size={26}
                    style={{color: tintColor}}
                />
            ),
        }
    },
    UserIndex: {
        screen:UserIndex,
        navigationOptions: {
            tabBarLabel: '我',
            tabBarIcon: ({tintColor, focused}) => (
                <Icons
                    name={focused ? 'emoticon-poop' : 'emoticon-poop-outline'}
                    size={26}
                    style={{color: tintColor}}
                />
            ),
        }
    }
});
const MainCoach = createBottomTabNavigator({
    CourseManage: {
        screen:  CourseManage,
        navigationOptions: {
            tabBarLabel: '课程管理',
            tabBarIcon: ({tintColor, focused}) => (
                <Icons
                    name={focused ? 'account' : 'account-outline'}
                    size={26}
                    style={{color: tintColor}}
                />
            ),
        }
    },
    StudentReply: {
        screen:StudentReply,
        navigationOptions: {
            tabBarLabel: '反馈',
            tabBarIcon: ({tintColor, focused}) => (
                <Icons
                    name={focused ? 'account-group' : 'account-group-outline'}
                    size={26}
                    style={{color: tintColor}}
                />
            ),
        }
    },

    CoachIndex: {
        screen:CoachIndex,
        navigationOptions: {
            tabBarLabel: '我',
            tabBarIcon: ({tintColor, focused}) => (
                <Icons
                    name={focused ? 'emoticon-poop' : 'emoticon-poop-outline'}
                    size={26}
                    style={{color: tintColor}}
                />
            ),
        }
    }
});


export default class App extends Component{
    constructor(props){
        super(props)
        this.state = {
            checkedLogin: false,
            isLoggedIn: false,
            main: 'MainStudent'
        }
    }
    componentDidMount() {
        StorageUtil.get('hasLogin', (error, object) => {
            if (!error && object != null && object.hasLogin) {
                if(object.hasLogin==='STUDENT'){
                    this.setState({
                        checkedLogin: true,
                        isLoggedIn: true,
                        main: 'MainStudent'
                    })
                }else if(object.hasLogin==='COACH'){
                    this.setState({
                        checkedLogin: true,
                        isLoggedIn: true,
                        main: 'MainCoach'
                    })
                }

            } else {
                this.setState({ checkedLogin: true, isLoggedIn: false });

            }
        });
    }
     /*   const self = this;
        //需要查询的键值
        const keys = ["email","password"];
        //根据键数组查询保存的键值对
        AsyncStorage.multiGet(keys, function(errs, result){
            //如果发生错误，这里直接返回（return）防止进入下面的逻辑
            if(errs||result[0][1] === null||result[1][1] === null){
                self.setState({
                    checkedLogin: true,
                    isLoggedIn: false
                });
                return;
            }
            self.setState({ checkedLogin: true, isLoggedIn: true });
        });
    }*/


  render() {
     const { checkedLogin, isLoggedIn } = this.state;
      if (!checkedLogin) {
          return null;
      }

      const AppNavigator = createAppContainer( createStackNavigator(
          {
              UserLogin: {
                  screen: UserLogin

              },
              MainStudent: {
                  screen: MainStudent
              },
              MainCoach: {
                  screen: MainCoach
              },
              UserInfo: {
                  screen: UserInfo
              },
              CourseHour: {
                screen: CourseHour
              },
              CourseScreen: {
                  screen: CourseScreen
              },
              ClubCard: {
                  screen:ClubCard
              },
              CourseSignIn: {
                  screen:CourseSignIn
              },
              ModifyScreen: {
                  screen:ModifyScreen
              },
              AddWeight: {
                  screen:AddWeight
              },
              CoachInfo :{
                  screen:CoachInfo
              },
              UpdatePassword :{
                  screen:UpdatePassword
              },
              StudentActivity :{
                  screen:StudentActivity
              },
              CoachCourse: {
                  screen:CoachCourse
              },
              AddCourse: {
                  screen:AddCourse
              },
              UpdateCourse: {
                  screen:UpdateCourse
              },
              UpdateStuPassword: {
                  screen:UpdateStuPassword
              },
              ModifyWeightScreen:{
                  screen:ModifyWeightScreen
              },
              ModifyHeightScreen:{
                  screen:ModifyHeightScreen
              },
              ModifyBirthScreen: {
                  screen:ModifyBirthScreen
              },
              ModifyPhoneScreen:{
                  screen:ModifyPhoneScreen
              },
              SubmitScore:{
                  screen:SubmitScore
              }

          },
          {initialRouteName: isLoggedIn ?  this.state.main: 'UserLogin' ,
              headerMode: 'none'}
      ))

      return (
          <View style={styles.container}>
              <AppNavigator />
          </View>
      );
  }
}


const styles = StyleSheet.create({
    container: {
        flex: 1
    }
});