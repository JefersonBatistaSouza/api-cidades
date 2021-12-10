package com.jeferson.apicidades.servico;

/**
 * @author Jeferson
 * @version  v1.0
 */
public class CauculaDistancia{
    /**
     * Raio da terra
     */
    private static final int EARTH_RADIUS_KM = 6371;

    /**
     *
     * @param latOrigem latitude de origem
     * @param lonOrigem longitude de origem
     * @param latDestino latitude de destino
     * @param lonDestino longitude de destino
     * @return Disntância em linha reta
     */
    public static Double distanceKM(Double latOrigem,Double lonOrigem,Double latDestino, Double lonDestino ){
        /**
         * Convertendo as coordenada em dados radianos.
         */
        double origemLatRad = Math.toRadians(latOrigem);
        double origemLonRad = Math.toRadians(lonOrigem);
        double destinoLatRad = Math.toRadians(latDestino);
        double destinoLonRad = Math.toRadians(lonDestino);
        /**
         * Diferençao da latitude e longitude dos pontos
         */
        double diferencaLat = (origemLatRad- destinoLatRad);
        double diferencaLon = (origemLonRad- destinoLonRad);
        /**
         * Calculo da distancia
         */
        double distancia = Math.sin(diferencaLat / 2) * Math.sin(diferencaLat / 2)
                + Math.cos(origemLatRad)
                * Math.cos(origemLatRad)
                * Math.sin(diferencaLon / 2) * Math.sin(diferencaLon / 2),
                c = 2 * Math.atan2(Math.sqrt(distancia), Math.sqrt(1 - distancia));
        /**
         * Retorna a distancia em KM
         */
        return (EARTH_RADIUS_KM * c);
    }
    /*
    public static void main(String[] args) {
        System.out.println(CauculaDistancia.distanceKM(
                -20.07780075073240000,
                -41.12609863281250,
                -18.54820060729980000,
                -40.98540115356450000));
    }
    */
}
