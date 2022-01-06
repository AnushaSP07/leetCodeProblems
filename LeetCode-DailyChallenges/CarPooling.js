/* 
There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).

You are given the integer capacity and an array trips where trip[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true */

/* Hint :::
As we have 1000 stops.
So, we can just calculate how many passengers can get in and out at their location.
Approach :

Process all trips, adding the passenger count to the start location and subtracting it from the end. 

A positive value for a certain location after processing all trips indicates that we are getting more passengers; 

And negative value indicates that we are getting more empty seats.

Finally, go over all of the stops to see if we've ever exceeded our vehicle's capacity

input trips : [[3,2,7] , [3,7,9] , [8,3,9]] 
[3,2,7] ==> (+3)  2---------------------7 (-3)
[8,3,9] ==>     (+8) 3--------------------9 (-8)
[3,7,9] ==>                      (+3)7-----9 (-3)

*/ 

/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function(trips, capacity) {
	// Because from and to is between 0 and 1000. Idea is to store counts in an array of size 1001.
    let lengthOfTrip = Array(1001).fill( 0 );
      
	// Update passenger change for each trip
    for( const [trip, i, j] of trips){
        lengthOfTrip[i] += trip; // Increment when passenger is on board
        lengthOfTrip[j] -= trip; // decrement when they depart
    }
    
    let carLoad = 0; 
	// Count total passenger for each bus top
    // we have the count array, we perform a line sweep from 0 to 1000 and track its total
    for( let i = 0 ; i < lengthOfTrip.length ; i++ ){
        carLoad += lengthOfTrip[i];    
        if( carLoad > capacity ){ // Reject when the car is overloaded somewhere
            return false;
        } 
    }
    return true; // Accept only if all trip is safe
};
