export default function getImage(objectId){
    switch (objectId) {
        case 1:
            return require('./images/things-fall-apart.jpg');
        case 2:
            return require('./images/fairy-tales.jpg');
        case 3:
            return require('./images/the-divine-comedy.jpg');
        case 4:
            return require('./images/the-epic-of-gilgamesh.jpg');
        case 5:
            return require('./images/the-book-of-job.jpg');
        case 6:
            return require('./images/one-thousand-and-one-nights.jpg');
        case 7:
            return require('./images/njals-saga.jpg');
        case 8:
            return require('./images/pride-and-prejudice.jpg');
        case 9:
            return require('./images/le-pere-goriot.jpg');
        case 10:
            return require('./images/molloy-malone-dies-the-unnamable.jpg');
        case 11:
            return require('./images/the-decameron.jpg');
        case 12:
            return require('./images/ficciones.jpg');
        case 13:
            return require('./images/wuthering-heights.jpg');
        case 14:
            return require('./images/l-etranger.jpg');
        case 15:
            return require('./images/poems-paul-celan.jpg');
        case 16:
            return require('./images/voyage-au-bout-de-la-nuit.jpg');
        default:
            return require('./images/things-fall-apart.jpg');
    }
};