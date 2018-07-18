<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="resources/js/webjars/sockjs.min.js"></script>
    <script src="resources/js/webjars/stomp.min.js"></script>
</head>

<body>
<br>
<br>
<p id="notifications-area" style="font-size: 92px; text-align:center; ">
    Ingreso al Evento
</p>
<!-- Javascript functions -->
<script>
    /**
     * Open the web socket connection and subscribe the "/notify" channel.
     */
    function connect() {
        // Create and init the SockJS object
        var socket = new SockJS('${pageContext.request.contextPath}/ws');
        var stompClient = Stomp.over(socket);
        // Subscribe the '/notify' channell
        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/acceso/notificar', function(notification) {
                // Call the notify function when receive a notification
                notify("Bienvenid@ " + JSON.parse(notification.body).nombre);
            });
        });

        return;
    } // function connect

    /**
     * Display the notification message.
     */
    function notify(message) {
        $("#notifications-area").html(message + "\n");
        return;
    }

    /**
     * Init operations.
     */
    $(document).ready(function() {

        // Start the web socket connection.
        connect();

    });
</script>

</body>

</html>