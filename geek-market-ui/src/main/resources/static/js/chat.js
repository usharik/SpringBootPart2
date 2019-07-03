$("#myModal").draggable({
    handle: ".modal-header"
});
// document.getElementById('chatLink').click();

var stompClient = null;

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/chat_out/receive_message', function (payload) {
            console.log(payload);
            var msg = JSON.parse(payload.body);
            $("ul.chat").append(buildMessageHtml(msg.username, msg.message, false));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/chat_in/send_message", {},
        JSON.stringify({
            'username' : 'noname',
            'message': $("#message-text").val()
        }));
    $("ul.chat").append(buildMessageHtml('noname', $("#message-text").val(), true));
}

function buildMessageHtml(username, message, direction) {
    return  '<li class="' + (direction ? 'left' : 'right') + ' clearfix">' +
        '<span class="chat-img ' + (direction ? 'pull-left' : 'pull-right') + '">' +
        '<img src="http://placehold.it/50/55C1E7/fff&text=U" alt="User Avatar" class="img-circle"/>' +
        '</span>' +
        '<div class="chat-body clearfix">' +
        '<div class="header">' +
        '<strong class="' + (direction ? 'pull-right' : '') + ' primary-font">' + username + '</strong>' +
        '</div>' +
        '<p>' + message + '</p>' +
        '</div>' +
        '</li>'
}

$(function () {
    $( "#btn-send" ).click(function() { sendMessage(); });
});

connect();