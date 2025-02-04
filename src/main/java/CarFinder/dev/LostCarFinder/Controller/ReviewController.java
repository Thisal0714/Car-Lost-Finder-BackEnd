package CarFinder.dev.LostCarFinder.Controller;


import CarFinder.dev.LostCarFinder.Dto.ReqRes;
import CarFinder.dev.LostCarFinder.Dto.ReviewDto;
import CarFinder.dev.LostCarFinder.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping(value = "/addReview")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewDto reviewDto){
        return ResponseEntity.ok(reviewService.addReview(reviewDto));
    }
    @GetMapping("/getAllReviews")
    public ResponseEntity<ReviewDto> getAllUsers(){
        return ResponseEntity.ok(reviewService.getAllReview());

    }

}
