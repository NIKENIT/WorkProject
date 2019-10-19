package com.unit5.Cargo;

import com.unit5.location.Location;
import com.unit5.location.LocationTransportation;
import com.unit5.product.Product;
import com.unit5.product.ProductType;
import com.unit5.transport.TransportType;
import com.unit5.transport.Transportation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CargoService {

    public static void main(String[] args) {
        List<Cargo> products = getCargo();
        String shortestPath = getOptimalRoute(products);
        System.out.println("Наикратчайший из всех путей = " + shortestPath);
    }


    private static List<Cargo> getCargo() {
        Location krasnoyarsk = new Location(1, "Красноярск");
        Location novosibirsk = new Location(2, "Новосибирск");
        Location nowhere = new Location(1337, "Далеко и надолго");

        return Arrays.asList(
                new Cargo(1, "Саянита", 800, krasnoyarsk, novosibirsk),
                new Cargo(2, "Саянские", 300, krasnoyarsk, novosibirsk),
                new Cargo(3, "Красноярские столбы", 250, krasnoyarsk, nowhere),
                new Cargo(4, "Багира", 444, krasnoyarsk, nowhere),
                new Cargo(5, "Шоколад темный", 1, nowhere, novosibirsk),
                new Cargo(6, "Шоколад молочный", 666, nowhere, krasnoyarsk)
        );
    }

    private static String getOptimalRoute(List<Cargo> cargo) {
        List<LocationTransportation> transportations = getTransportations();

        return cargo.stream()
                .peek(item -> System.out.println("Расчет пути для груза " + item.getName()))
                .peek(item -> System.out.println("From " + item.getLocationFrom().getName() + " to " + item.getLocationTo().getName()))
                .map(item -> transportations.stream()
                        // криво и косо находим тот же элемент транспортации, какой и в карго. Ибо лень.
                        .filter(transport -> transport.getLocationFrom().getId() == item.getLocationFrom().getId() && transport.getLocationTo().getId() == item.getLocationTo().getId())
                        .map(LocationTransportation::getLowestTransportation)
                        .peek(transp -> System.out.println("Самый дешевый способ перевозки для данного типа - " + transp.getTransportTypeString()))
                        .map(Transportation::getTotalPrice)
                        .findFirst()
                        .orElse(0)
                )
                .peek(price -> System.out.println("Наименьшая цена перевозки для данного груза = " + price))
                .peek(price -> System.out.println(""))
                .min(Comparator.comparing(Number::doubleValue))
                .map(Object::toString)
                .orElse("Что-то пошло не так");
    }

    private static List<LocationTransportation> getTransportations() {
        // дублируем код локаций потому что когда я придумывал как это слделать я думал о бзах данных и консистентных данных
        Location krasnoyarsk = new Location(1, "Красноярск");
        Location novosibirsk = new Location(2, "Новосибирск");
        Location nowhere = new Location(1337, "Далеко и надолго");

        Transportation[] kToNov = new Transportation[]{
                new Transportation(TransportType.Air, 1500, 500),
                new Transportation(TransportType.Maritime, 3000, 100),
                new Transportation(TransportType.Rail, 8000, 80),
                new Transportation(TransportType.Road, 6000, 50),
        };

        Transportation[] kToNowhere = new Transportation[]{
                new Transportation(TransportType.Air, 8000, 500),
                new Transportation(TransportType.Maritime, 9000, 100),
                new Transportation(TransportType.Rail, 10000, 80),
                new Transportation(TransportType.Road, 11000, 50),
        };

        Transportation[] nToNowhere = new Transportation[]{
                new Transportation(TransportType.Air, 11000, 500),
                new Transportation(TransportType.Maritime, 10000, 100),
                new Transportation(TransportType.Rail, 9000, 80),
                new Transportation(TransportType.Road, 8000, 50),
        };

        return Arrays.asList(
                new LocationTransportation(1, krasnoyarsk, novosibirsk, kToNov),
                new LocationTransportation(2, krasnoyarsk, nowhere, kToNowhere),
                new LocationTransportation(3, novosibirsk, nowhere, nToNowhere),
                new LocationTransportation(4, nowhere, novosibirsk, nToNowhere),
                new LocationTransportation(5, nowhere, krasnoyarsk, kToNowhere)
        );
    }
}
