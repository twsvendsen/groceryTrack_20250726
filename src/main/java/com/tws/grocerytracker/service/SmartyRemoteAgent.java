package com.tws.grocerytracker.service;

import com.smartystreets.api.BasicAuthCredentials;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.us_street.*;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SmartyRemoteAgent {

    public static final String SMARTY_AUTH_ID = "SMARTY_AUTH_ID";
    public static final String SMARTY_AUTH_TOKEN = "SMARTY_AUTH_TOKEN";

    public Candidate lookUpAddress(String streetAddress, String location) throws Exception {
        try (Client client = buildSmartyClient()) {
            Lookup lookup = convertRawAddressToLookup(streetAddress, location);
            // service call
            client.send(lookup);
            List<Candidate> results = lookup.getResult();
            if (results.isEmpty()) {
                throw new Exception("smarty lookup failed");
            }
            return results.getFirst();
        } catch (IOException ex) {
            throw new Exception("smarty lookup failed");
        }
    }

    private Client buildSmartyClient() {
        return new ClientBuilder(new BasicAuthCredentials(
                // TODO: set up auth variables
                System.getenv("SMARTY_AUTH_ID"),
                System.getenv("SMARTY_AUTH_TOKEN"))).buildUsStreetApiClient();
    }

    private Lookup convertRawAddressToLookup(String streetAddress, String location) {
        Lookup lookup = new Lookup();
        String[] locationDetails = StringUtils.splitCommaSeparated(location);
        // TODO: refine
        if(locationDetails.length >= 3) {
            lookup.setCity((locationDetails[0]));
            lookup.setState(locationDetails[1]);
            lookup.setZipCode(locationDetails[2]);
        }
        lookup.setStreet(streetAddress);
        return lookup;
    }
}
