package dk.easj.anbo.fbimostwanted2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import dk.easj.anbo.fbimostwanted2.databinding.FragmentSecondBinding
import dk.easj.anbo.fbimostwanted2.models.CatalogViewModel

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val catalogViewModel: CatalogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = requireArguments()
        val secondFragmentArgs: SecondFragmentArgs = SecondFragmentArgs.fromBundle(bundle)
        val position = secondFragmentArgs.position
        val item = catalogViewModel[position]
        if (item == null) {
            binding.textviewDescription.text = "No such item!"
            return
        }
        binding.textviewTitle.text = item.title
        if (item.details != null) {
            val details =
                item.details.subSequence(3, item.details.length - 4) // remove <p> from details
            binding.textviewDescription.text = details
        }

        if (item.images != null) {
            Glide.with(requireActivity())
                .load(item.images[0].original)
                .into(binding.imageView)
        }

        binding.buttonSecond.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}