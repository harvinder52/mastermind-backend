package com.mastermind.mastermind;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class RequestController{
	
	@CrossOrigin("http://localhost:3000")
	@GetMapping("/submit")
	public String submit() {
		
		return "mastermind's backend is live!";
		
	}
	@CrossOrigin("http://localhost:3000")
	@PostMapping("/verifyGuess")
    public ArrayList < Character > verifyGuess(@RequestBody int[] guess) {
		int[] code = {2,3,3,1};
		  ArrayList < Character > hints = new ArrayList < > ();
	 ArrayList < Integer > list = new ArrayList < > ();
	 
	 for (int i = 0; i < code.length; i++) {

         list.add(code[i]);
         

     }
		for (int i = 0; i < guess.length; i++) {

            if (code[i] == guess[i]) {
                
                hints.add('-');
                list.set(i, 9);

            }
        }
		 for (int i = 0; i < guess.length; i++) {

             if (list.contains(guess[i]) && (code[i] != guess[i])) { //1232
                
                 hints.add('+');
                 list.set(list.indexOf(guess[i]), 9);

             }

         }
        return  hints;
    }

}