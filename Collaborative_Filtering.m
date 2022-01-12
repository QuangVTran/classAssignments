%for the example shown, use 4 users, 5 movies, and 2 genres

promptNumOfUsers = 'How many users?' ;

numOfUsers = input(promptNumOfUsers)

promptNumOfMovies = 'How many Movies?' ; 

numOfMovies = input(promptNumOfMovies)

%this matrix below is the initial matrix that we will try to recreate with
%two matrix factors
randReccomenderMatrix = randi([0 8],numOfUsers,numOfMovies)

promptNumOfGenres = 'How many unique genres in these movies? (Action, horror, adventure, comedy etc) \n Please input a number between 1 and 4\n';

numOfGenres = input(promptNumOfGenres);

promptSomething = 'Press Enter to continue'


%generate a preference matrix, consisting of 1 or 0's with dimensions users
%by genres, for our example, it should be 4x2 matrix
randUserPreferenceMatrix = randi([0 1],numOfUsers,numOfGenres)

randMovieGenreScoreMatrix = randi([1 4],numOfGenres,numOfMovies)

result = randUserPreferenceMatrix * randMovieGenreScoreMatrix

counter = 0; 

%These variables are for storing and keeping the best possible outcomes as
%the matrix randomizing loop runs
comparisonMatrix = result==randReccomenderMatrix
    
bestResultSoFar = zeros(numOfUsers,numOfMovies);

bestUserPreferenceMatrix = zeros(numOfUsers,numOfGenres);

bestMovieGenreScoreMatrix = zeros(numOfMovies,numOfGenres);

sumOfComparisonMatrix = 0;


%The main while loop of the algorithm, essentially, the loop fills the
%two matrices up with complete random values, and multiplies them together
%to get a resulting matrix. This resulting matrix is compared to the
%initial matrix, and the resulting matrix with the most similarities will
%be saved. Without machine learning code, the next best option is brute force.
%With a lot of trials, and a little bit a luck, we might be able to get a
%matrix similar to the initial matrix with factorized matrices. 
if ~isequal(result, randReccomenderMatrix)
    
while(counter ~= 100000)
   
    randUserPreferenceMatrix = randi([0 1],numOfUsers,numOfGenres)

    randMovieGenreScoreMatrix = randi([1 4],numOfGenres,numOfMovies)
    
    result = randUserPreferenceMatrix * randMovieGenreScoreMatrix;
    
   counter = counter + 1
   
   randReccomenderMatrix

   result 
   
   %this comparison matrix is a zero matrix that fills up with one's when
   %element <i,j> of both the initial matrix and the resulting matrix are
   %the same. The more ones there are, the more "similar" the matrices are
   comparisonMatrix = result==randReccomenderMatrix
   
   %this if statement counts up the numbers of ones in the comparison
   %matrix, and therefore, records the most similar matrix throughout the
   %loop
   if ( (sum(comparisonMatrix,'all') > sumOfComparisonMatrix) )
       sumOfComparisonMatrix = sum(comparisonMatrix,'all')
       bestResultSoFar = result;
       bestUserPreferenceMatrix = randUserPreferenceMatrix;
       bestMovieGenreScoreMatrix = randMovieGenreScoreMatrix;
   end
   
   
   
end

end


%this if statement will tell us if the resulting matrix is identical to the
%initial matrix (very,very unlikely)
if (result == randReccomenderMatrix)
    disp('right')
    counter
else
    disp('wrong')
    counter
end

%The overall results
finalComparisonMatrix = randReccomenderMatrix==bestResultSoFar

randReccomenderMatrix

bestUserPreferenceMatrix

bestMovieGenreScoreMatrix

bestResultSoFar




