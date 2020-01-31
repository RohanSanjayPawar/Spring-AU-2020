import * as React from 'react';
import { View, StyleSheet, Dimensions } from 'react-native';
import { TabView, SceneMap } from 'react-native-tab-view';
import Books from './Books';

const FirstRoute = () => (
  <View style={[styles.scene, { backgroundColor: 'cadetblue' }]}>
    <Books genre="fiction"></Books>
  </View>
);

const SecondRoute = () => (
  <View style={[styles.scene, { backgroundColor: 'goldenrod' }]}>
    <Books genre="romcom"></Books>
  </View>
);

const ThirdRoute = () => (
  <View style={[styles.scene, { backgroundColor: 'green' }]}>
    <Books genre="thriller" ></Books>
  </View>
);

const FourthRoute = () => (
  <View style={[styles.scene, { backgroundColor: 'violet' }]}>
    <Books genre="scifi"></Books>
  </View>
);

const initialLayout = { width: Dimensions.get('window').width };

export default function TabViewExample() {
  const [index, setIndex] = React.useState(0);
  const [routes] = React.useState([
    { key: 'first', title: 'Fiction' },
    { key: 'second', title: 'Romcom' },
    { key: 'third', title: 'Thriller' },
    { key: 'fourth', title: 'SciFi' },
  ]);

  const renderScene = SceneMap({
    first: FirstRoute,
    second: SecondRoute,
    third: ThirdRoute,
    fourth: FourthRoute
  });

  return (
    <TabView
      navigationState={{ index, routes }}
      renderScene={renderScene}
      onIndexChange={setIndex}
      initialLayout={initialLayout}
    />
  );
}

const styles = StyleSheet.create({
  scene: {
    flex: 1,
  },
});
