package pl.coderslab.service;

import pl.coderslab.entity.Status;

import static pl.coderslab.entity.Status.*;


public class StatusService {

    public static String stringFromStatus(Status status) {
        switch (status) {
            case READY:
                return "READY";
            case ACCEPTED:
                return "READY";
            case CANCELLED:
                return "CANCELLED";
            case CONFIRMED:
                return "CONFIRMED";
            case IN_REPAIR:
                return "IN_REPAIR";
            default:
                return "";

        }
    }

    public static Status statusFromString(String status) {
        switch (status) {
            case "READY":
                return READY;
            case "ACCEPTED":
                return ACCEPTED;
            case "CANCELLED":
                return CANCELLED;
            case "CONFIRMED":
                return CONFIRMED;
            case "IN_REPAIR":
                return IN_REPAIR;
            default:
                return null;

        }
    }
}
