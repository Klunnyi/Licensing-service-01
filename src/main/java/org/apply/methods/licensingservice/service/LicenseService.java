package org.apply.methods.licensingservice.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apply.methods.licensingservice.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    @Autowired
    private MessageSource messages;

    @NonNull
    public License getLicense(@NonNull String licenseId, @NonNull String organizationId) {
        final License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");

        return license;
    }

    public String createLicense(@NonNull License license, @NonNull String organizationId, @NonNull Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messages.getMessage("license.create.message", null, locale), license);
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(
                    "This is the put and the object is: %s", license.toString());
//                    messages.getMessage("license.create.message", null, null),
//                    license);
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage = String.format(
                "Deleting license with id %s for the organization %s",
                licenseId, organizationId);
        return responseMessage;
    }
}