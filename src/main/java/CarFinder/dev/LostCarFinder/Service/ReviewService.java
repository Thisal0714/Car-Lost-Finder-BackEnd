package CarFinder.dev.LostCarFinder.Service;


import CarFinder.dev.LostCarFinder.Dto.ReviewDto;
import CarFinder.dev.LostCarFinder.Entity.Review;
import CarFinder.dev.LostCarFinder.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDto addReview(ReviewDto registrationRequest){
        ReviewDto resp=new ReviewDto();

        try{
            Review review=new Review();
            review.setName(registrationRequest.getName());
            review.setText(registrationRequest.getText());
            review.setTimestamp(registrationRequest.getTimestamp());

            Review reviewResult=reviewRepository.save(review);

            resp.setReview(reviewResult);
            resp.setStatusCode(200);
            resp.setMessage("Review Added Succefully");
        }catch(Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());

        }
        return resp;
    }

    public ReviewDto getAllReview(){
        ReviewDto reviewDto=new ReviewDto();

        try{
            List<Review> result=reviewRepository.findAll();
            if(!result.isEmpty()){
            reviewDto.setReviews(result);
            reviewDto.setStatusCode(200);
            reviewDto.setMessage("Successful");
            }else {
                reviewDto.setStatusCode(404);
                reviewDto.setMessage("No reviews found");
            }
            return reviewDto;

        }catch (Exception e){

            reviewDto.setStatusCode(500);
            reviewDto.setMessage("Error Occurred"+e.getMessage());
            return reviewDto;
        }
    }

}
