package com.vti.mockpjmomovinhanai.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/donation")
@CrossOrigin("*")
@Validated
public class DonationController {
}
