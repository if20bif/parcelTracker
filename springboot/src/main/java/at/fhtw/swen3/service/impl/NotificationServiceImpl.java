package at.fhtw.swen3.service.impl;

import at.fhtw.swen3.model.Notification;
import at.fhtw.swen3.service.NotificationService;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(Notification notification) {
        String expoPushToken = notification.getParcel().getRecipient().getExpoPushToken();

        StringBuilder sb = new StringBuilder();
        sb.append("{\"to\":\"" + expoPushToken + "\",");
        sb.append("\"title\":\"Parcel submitted!\",");
        sb.append("\"body\":\"TrackingID: " + notification.getParcel().getTrackingId() +"\",");
        sb.append("\"data\":{\"trackingId\":\"" + notification.getParcel().getTrackingId() + "\", \"State\":\"" + notification.getParcel().getState().name() + "\"}}");

        String url = "https://exp.host/--/api/v2/push/send";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(sb.toString()))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
