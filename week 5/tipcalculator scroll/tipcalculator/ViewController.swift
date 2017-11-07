//
//  ViewController.swift
//  tipcalculator
//
//  Created by Aileen Pierce
//  Copyright (c) 2017 Aileen Pierce. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    @IBOutlet weak var checkAmount: UITextField!
    @IBOutlet weak var tipPercent: UITextField!
    @IBOutlet weak var people: UITextField!
    @IBOutlet weak var tipDue: UILabel!
    @IBOutlet weak var totalDue: UILabel!
    @IBOutlet weak var totalDuePerPerson: UILabel!
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func updateTipTotals() {
        var amount:Float //check amount
        var pct:Float //tip percentage
        
        if checkAmount.text!.isEmpty {
           amount = 0.0
        } else {
            amount = Float(checkAmount.text!)!
        }
        if tipPercent.text!.isEmpty {
            pct = 0.0
        }
        else {
            pct = Float(tipPercent.text!)!/100
        }

        let numberOfPeople=Int(people.text!) //returns an optional
        let tip=amount*pct
        let total=amount+tip
        var personTotal : Float = 0.0 //specify Float so it's not a Double
        if numberOfPeople != nil {
            if numberOfPeople! > 0 {
                personTotal = total / Float(numberOfPeople!)
            }else {
                //create a UIAlertController object
                let alert=UIAlertController(title: "Warning", message: "The number of people must be greater than 0", preferredStyle: UIAlertControllerStyle.alert)
                //create a UIAlertAction object for the button
                let cancelAction=UIAlertAction(title: "Cancel", style:UIAlertActionStyle.cancel, handler: nil)
                alert.addAction(cancelAction) //adds the alert action to the alert object
                let okAction=UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: {action in
                    self.people.text="1"
                    self.updateTipTotals()
                })
                alert.addAction(okAction)
                present(alert, animated: true, completion: nil)
            } //end else
        }
        
        //format results as currency
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle=NumberFormatter.Style.currency //set the number style
        tipDue.text=currencyFormatter.string(from: NSNumber(value: tip)) //returns a formatted string
        totalDue.text=currencyFormatter.string(from: NSNumber(value: total))
        totalDuePerPerson.text=currencyFormatter.string(from: NSNumber(value: personTotal))
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        updateTipTotals()
    }
    
    override func viewDidLoad() {
        checkAmount.delegate=self
        tipPercent.delegate=self
        people.delegate=self
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }


    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

