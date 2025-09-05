package com.epam.newThings.readFromApplicationProp;

import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;


// we can use record also here

@ConfigurationProperties(prefix = "spring")
@Validated
public class ApplicationProperties {

    @NotBlank                         // validations ; so that it fails if prop not correct at start only
    private final String mazak;       // final to make it immutable (setter also removed)

    public Datasource getDatasource() {
        return datasource;
    }

    private final Datasource datasource;

    public ApplicationProperties(String mazak, Datasource datasource) {
        this.mazak = mazak;
        this.datasource = datasource;
    }

    public String getMazak() {
        return mazak;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "port='" + mazak + '\'' +
                ", datasource=" + datasource +
                '}';
    }


    public static class Datasource{
       private final String url;

        public Datasource(String url, String userName) {
            this.url = url;
            this.userName = userName;
        }

        @Override
        public String toString() {
            return "Datasource{" +
                    "url='" + url + '\'' +
                    ", userName='" + userName + '\'' +
                    '}';
        }

        private final String userName;

        public String getUrl() {
            return url;
        }

        public String getUserName() {
            return userName;
        }
    }
}
