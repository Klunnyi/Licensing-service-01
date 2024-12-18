package org.apply.methods.licensingservice.controller;

//import com.optimagrowth.license.model.License;
//import com.optimagrowth.license.service.LicenseService;

import lombok.RequiredArgsConstructor;
import org.apply.methods.licensingservice.model.License;
import org.apply.methods.licensingservice.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.hateoas.server.mvc.WebMvcLink-Builder.WebMvcLinkBuilder;

import java.util.Locale;

@RestController
@RequestMapping(value = "v1/organization/{organizationId}/license")
@RequiredArgsConstructor
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId) {
        final License license = licenseService.getLicense(licenseId, organizationId);
        return ResponseEntity.ok(license);
    }

    @PostMapping
    public ResponseEntity<String> createLicense(@PathVariable("organizationId") String organizationId, @RequestBody License request) {
        return ResponseEntity.ok(licenseService.createLicense(request, organizationId));
    }

    @PutMapping
    public ResponseEntity<String> updateLicense(
            @PathVariable("organizationId") String organizationId, @RequestBody License request) {
        return ResponseEntity.ok(licenseService.updateLicense(request,
                organizationId));
    }

    @DeleteMapping(value="/{licenseId}")
    public ResponseEntity<String> deleteLicense(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
    }
}

//    private final LicenseService licenseService;
//
//    @GetMapping("/{licenseId}")                  // @PathVariable - эта аннотация обозначает значение параметра из URL
//    public ResponseEntity<License> getLicense(@PathVariable("organizationId") String organizationId,
//                                              @PathVariable("licenseId") String licenseId) {
//        License license = licenseService.getLicense(licenseId, organizationId);
//
//        license.add(linkTo(methodOn(LicenseController.class)
//                        .getLicense(organizationId, license.getLicenseId()))
//                        .withSelfRel(),
//                linkTo(methodOn(LicenseController.class)
//                        .createLicense(organizationId, license, null))
//                        .withRel("createLicense"),
//                linkTo(methodOn(LicenseController.class)
//                        .updateLicense(organizationId, license))
//                        .withRel("updateLicense"),
//                linkTo(methodOn(LicenseController.class)
//                        .deleteLicense(organizationId, license.getLicenseId()))
//                        .withRel("deleteLicense"));
//        return ResponseEntity.ok(license);
//    }
//
//    @PutMapping
//    public ResponseEntity<String> updateLicense(@PathVariable("organizationId") String organizationId,
//                                                @RequestBody License request) {
//        return ResponseEntity.ok(licenseService.updateLicense(request, organizationId));
//    }
//
//    @PostMapping
//    public ResponseEntity<String> createLicense(@PathVariable("organizationId") String organizationId,
//                                                @RequestBody License request,
//                                                @RequestHeader(value = "Accept-Language", required = false) Locale locale) {
//        return ResponseEntity.ok(licenseService.createLicense(request, organizationId, locale));
//    }
//
//    @DeleteMapping("/{licenseId}")
//    public ResponseEntity<String> deleteLicense(@PathVariable("organizationId") String organizationId,
//                                                @PathVariable("licenseId") String licenseId) {
//        return ResponseEntity.ok(licenseService.deleteLicense(licenseId, organizationId));
//    }

