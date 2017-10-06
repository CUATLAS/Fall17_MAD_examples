//
//  ViewController.swift
//  location
//
//  Created by Aileen Pierce
//  Copyright (c) 2017 Aileen Pierce. All rights reserved.
//

import UIKit
import MapKit
import CoreLocation

class ViewController: UIViewController{

    @IBOutlet weak var mapView: MKMapView!
    
     //basic map with set location
    override func viewDidLoad() {
        let location = CLLocationCoordinate2D(
            latitude: 40.74836,
            longitude: -73.984607
        )
        let span = MKCoordinateSpanMake(0.05, 0.05) //defines the area spanned by a map region
        let region = MKCoordinateRegion(center: location, span: span) //region of the map to be displayed
        mapView.setRegion(region, animated: true) //animates changing the currently visible region
        let annotation = MKPointAnnotation() //create an annotation
        annotation.coordinate=location //sets the coordinates of the annotation
        annotation.title="Empire State Building" //sets the title of the annotation
        annotation.subtitle="New York" //sets the subtitle of the annotation
        mapView.addAnnotation(annotation) //adds the annotation to the map view
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

