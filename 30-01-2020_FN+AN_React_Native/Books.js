import React from 'react';
import {
    SafeAreaView,
    TouchableOpacity,
    FlatList,
    StyleSheet,
    Text,
    Image
} from 'react-native';

import getImage from './imageHelper';

function Item({ id, title, selected, onSelect, author, page, language, country }) {

    return (
        <TouchableOpacity
        onPress={() => onSelect(id)}
        style={[
            styles.item,
            { backgroundColor: selected ? 'violet' : 'pink' },
        ]}
        >
        <Text style={styles.title}>{title}</Text>
        {selected && <Text style={styles.title}>Author: {author}</Text>}
        {selected && <Text style={styles.title}>Language: {language}</Text>}
        {selected && <Text style={styles.title}>Country: {country}</Text>}
        {selected && <Text style={styles.title}>No. of Pages: {page}</Text>}
        {selected && <Image source={getImage(id)} style={{width: 200, height: 200}}></Image>}
        </TouchableOpacity>
    );
}

export default function Books({genre}) {

    const DATA = require('./books.json');

    const GENRE_DATA = [];
    const IMAGE = [];

    for(let i=0;i<DATA.length;i++) {
        if(DATA[i]["genre"] === genre) {
            GENRE_DATA.push(DATA[i]);
        }
    }

    const [selected, setSelected] = React.useState(new Map());

    const onSelect = React.useCallback(
        id => {
        const newSelected = new Map(selected);
        newSelected.set(id, !selected.get(id));

        setSelected(newSelected);
        },
        [selected],
    );
    
    return (
        <SafeAreaView style={styles.container}>
        <FlatList
            data={GENRE_DATA}
            renderItem={({ item }) => (
            <Item
                id={item.id}
                title={item.title}
                selected={!!selected.get(item.id)}
                onSelect={onSelect}
                author = {item.author}
                page = {item.pages}
                language = {item.language}
                country = {item.country}
            />
            )}
            keyExtractor={item => item.id}
            extraData={selected}
        />
        </SafeAreaView>
    );
    }

    const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginTop: 30,
    },
    item: {
        backgroundColor: '#f9c2ff',
        padding: 20,
        marginVertical: 8,
        marginHorizontal: 16,
        alignItems: 'center',
        justifyContent: 'center',
    },
    title: {
        fontSize: 18,
    },
});