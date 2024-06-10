package SharePlatform.SharePlatform.Service;

import SharePlatform.SharePlatform.Converter.PostConverter;
import SharePlatform.SharePlatform.DTO.PostDTO;
import SharePlatform.SharePlatform.Entity.Posts;
import SharePlatform.SharePlatform.Entity.Users;
import SharePlatform.SharePlatform.Repository.PostRepository;
import SharePlatform.SharePlatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PostServiceImpl implements  PostService{


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostConverter postConverter;

    @Autowired
    UserRepository userRepository;


    @Override
    public PostDTO save(PostDTO postDTO) {
        Users user = userRepository.findById(postDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Posts post = postConverter.convertToEntity(postDTO, user);
        post = postRepository.save(post);
        return postConverter.convertToDTO(post);
    }

        @Override
        public PostDTO findById(Long id ) {
            return postRepository.findById(id)
                    .map(postConverter::convertToDTO)
                    .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll().stream()
                .map(postConverter::convertToDTO)
                .collect(Collectors.toList());
    }



    @Override
    public List<PostDTO> findByUserId(Long userId) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return postRepository.findByUser(user).stream()
                .map(postConverter::convertToDTO)
                .collect(Collectors.toList());
    }
}
