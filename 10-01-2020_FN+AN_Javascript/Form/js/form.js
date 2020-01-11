var players = ["messi", "ronaldo", "vandijk", "dejong", "alisson", "kante", "debruyne","mbappe","mane","trent","robertson","deligt"];

document.getElementById("search").oninput = () => {
    let search = document.getElementById("search").value;
    var reg = new RegExp(search);

    player_of_the_year = players.filter((player) => reg.test(player)).join(",");

    var playerSearch = document.getElementById("players");
    var playerSort = document.getElementById("sortPlayer");
    playerSearch.innerHTML = player_of_the_year;
    playerSort.innerHTML = player_of_the_year;
}

function sort() {
    var playerSort = document.getElementById("sortPlayer").innerHTML;
    var sorted = playerSort.split(",").sort().join(", ");
    var players = document.getElementById("sortPlayer");
    players.innerHTML = sorted;
}